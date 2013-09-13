package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.MoradorControllerBean;
import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.json.ComentarioJSON;
import br.com.webhomebeta.json.JsonPublicacao;
import br.com.webhomebeta.json.NovaPublicacaoJSON;
import br.com.webhomebeta.json.UsuarioPublicacaoJSON;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller

public class MoradorController {

	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MoradorControllerBean moradorControllerBean;
	
	// Inicializa a pagina com todos os parametros necessarios
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			//Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				//Pega o usuario que logou
				moradorControllerBean.setUsuario(usuarioService.getUsuarioByLogin(((UserDetailsImp) authentication.getPrincipal()).getUsername()));

			}
		}
		model.put("moradorControllerBean",moradorControllerBean);

		return new ModelAndView("home", model);
	}

	/*
	 * Cria um JSON com os dados necessarios para a publicacao
	 */
	@RequestMapping(value = "home/getPublicacao", method = RequestMethod.POST)
	public @ResponseBody
	ArrayList<JsonPublicacao> sendJsonPublicacao() {
	
		ArrayList<JsonPublicacao> jsonPublicacaos = new ArrayList<>();
		List<Publicacao> publicacaoes = publicacaoService.getPublicacoes();
		// Varre cada publicacao
		for (Publicacao p : publicacaoes) {
			// Cria uma lista para os comentarios desta publicacao
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
			if (moradorControllerBean.getUsuario().getIdUser() == p
					.getUsuarioPublicacao().getIdUser())
				jsonPublicacao.setProprietario(true);
			else
				jsonPublicacao.setProprietario(false);

			// Seta as publicacoes filtradas e as retorna para a VIEW
			jsonPublicacaos.add(jsonPublicacao);
		}

		return jsonPublicacaos;
	}

//	 @RequestMapping(value = "home/comentar", method = RequestMethod.POST)
//	 public @ResponseBody
//	 ComentarioTO comentar(
//	 @ModelAttribute("comentarioTO") ComentarioTO comentarioTO,
//	 @RequestParam Integer id, BindingResult bindingResult) {
//	 // Poderia setar o ID no comentarioTO pelo js?
//	 comentarioTO.setPublicacao(new Publicacao(id));
//	 comentarioTO.setUsuarioComentario(usuarioNaSessao);
//	 Comentario comentario = new Comentario();
//	 BeanUtils.copyProperties(comentarioTO, comentario);
//	 return comentarioTO;
//	 }

	@RequestMapping(value = "home/publicar", method = RequestMethod.POST)
	public @ResponseBody
	NovaPublicacaoJSON publicar(
			// Pega toda a publicacao
			@ModelAttribute("moradorControllerBean") MoradorControllerBean bean,
			BindingResult bindingResult) {
		bean.getPublicacaoTO().setUsuarioPublicacao(
				moradorControllerBean.getUsuario());
		Publicacao publicacao = new Publicacao();
		// salva no banco
		BeanUtils.copyProperties(bean.getPublicacaoTO(),
				publicacao);
		publicacaoService.salvar(publicacao);
		// monta o JSON de Publicacao.
		NovaPublicacaoJSON novaPublicacaoJSON = new NovaPublicacaoJSON(
				bean.getPublicacaoTO().getIdPublicacao(),
				bean.getPublicacaoTO().getPublicacao(),
				bean.getPublicacaoTO().getData().toString(),
				moradorControllerBean.getUsuario().getIdUser(),
				moradorControllerBean.getUsuario().getNome());

		return novaPublicacaoJSON;

	}

}
