package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.Binding;
import javax.print.attribute.standard.DateTimeAtCreation;

import org.hibernate.Hibernate;
import org.hibernate.mapping.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.ComentarioJSON;
import br.com.webhomebeta.json.Json;
import br.com.webhomebeta.json.JsonPublicacao;
import br.com.webhomebeta.json.UsuarioPublicacaoJSON;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.ComentarioTO;
import br.com.webhomebeta.to.PublicacaoTO;

@Controller
@SessionAttributes("usuarioNaSessao")
public class MoradorController extends AuthenticatedController {

	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;

	private Usuario usuarioNaSessao;

	// Inicializa a pagina com todos os parametros necessarios
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		usuarioNaSessao = obterUsuarioLogado();
		model.put("usuarioNaSessao", usuarioNaSessao);
		model.put("publicacaoTO", new PublicacaoTO());
		model.put("comentarioTO", new ComentarioTO());
		return new ModelAndView("home", model);
	}

	/*
	 * Cria um JSON com os dados necessarios para a publicacao
	 */
	@RequestMapping(value = "home/getPublicacao", method = RequestMethod.POST)
	public @ResponseBody
	ArrayList<JsonPublicacao> sendJsonPublicacao() {
		usuarioNaSessao = obterUsuarioLogado();
		ArrayList<JsonPublicacao> jsonPublicacaos = new ArrayList<>();
		List<Publicacao> publicacaoes = publicacaoService.getPublicacoes();
		// Varre cada publicacao
		for (Publicacao p : publicacaoes) {
			// Cria uma lista para os comentarios da publicacao
			ArrayList<ComentarioJSON> comentariosJSON = new ArrayList<>();
			// Adiciona os dados da publicacao, e o usuario que a fez
			JsonPublicacao jsonPublicacao = new JsonPublicacao(
					p.getPublicacao(), p.getIdPublicacao(), p.getData(),
					"imagem", new UsuarioPublicacaoJSON(p
							.getUsuarioPublicacao().getIdUser(), p
							.getUsuarioPublicacao().getNome()));
			// Varre os comentarios dentro da publicacao
			for (Comentario c : p.getComentarios()) {
				// Adiciona os dados do comentario
				ComentarioJSON cJSON = new ComentarioJSON(c
						.getUsuarioComentario().getIdUser(), c
						.getUsuarioComentario().getNome(), "=]",
						c.getIdComentario(), c.getData(), c.getComentario());
				// Adiciona a lista cada comentario
				comentariosJSON.add(cJSON);
			}
			// Seta os comentarios
			jsonPublicacao.setComentarios(comentariosJSON);

			// Verifica se a publicacao eh do usuario que esta logado
			if (usuarioNaSessao.getIdUser() == p.getUsuarioPublicacao()
					.getIdUser())
				jsonPublicacao.setProprietario(true);
			else
				jsonPublicacao.setProprietario(false);
			// Seta as publicacoes filtradas e as retorna para a VIEW
			jsonPublicacaos.add(jsonPublicacao);
		}

		return jsonPublicacaos;
	}

	@RequestMapping(value = "home/comentar", method = RequestMethod.POST)
	public @ResponseBody
	ComentarioTO comentar(
			@ModelAttribute("comentarioTO") ComentarioTO comentarioTO,
			@RequestParam Integer id, BindingResult bindingResult) {
		//Poderia setar o ID no comentarioTO pelo js? 
		comentarioTO.setPublicacao(new Publicacao(id));
		comentarioTO.setUsuarioComentario(usuarioNaSessao);
		Comentario comentario = new Comentario();
		BeanUtils.copyProperties(comentarioTO, comentario);
		return comentarioTO;
	}

	@RequestMapping(value = "home/publicar", method = RequestMethod.POST)
	public @ResponseBody
	Json publicar(@ModelAttribute("publicacaoTO") PublicacaoTO publicacaoTO,
			BindingResult bindingResult) {
		publicacaoTO.setUsuarioPublicacao(usuarioNaSessao);
		Publicacao publicacao = new Publicacao();
		BeanUtils.copyProperties(publicacaoTO, publicacao);
		publicacaoService.salvar(publicacao);

		return new Json("true");

	}

}
