package br.com.webhomebeta.controller;

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
		model.put("listPublicacoes", publicacaoService.getPublicacoes());
		return new ModelAndView("home", model);
	}

	@RequestMapping(value = "home/comentar", method = RequestMethod.POST)
	public @ResponseBody
	ComentarioTO comentar(
			@ModelAttribute("comentarioTO") ComentarioTO comentarioTO,
			@RequestParam Integer id, BindingResult bindingResult) {
			comentarioTO.setPublicacao(new Publicacao(id));
			comentarioTO.setUsuarioComentario(usuarioNaSessao);
			Comentario comentario = new Comentario();
			BeanUtils.copyProperties(comentarioTO, comentario);
		return comentarioTO;
	}

	@RequestMapping(value = "home/publicar", method = RequestMethod.POST)
	public @ResponseBody
	PublicacaoTO publicar(
			@ModelAttribute("publicacaoTO") PublicacaoTO publicacaoTO,
			BindingResult bindingResult) {
		publicacaoTO.setUsuarioPublicacao(usuarioNaSessao);
		Publicacao publicacao = new Publicacao();
		BeanUtils.copyProperties(publicacaoTO, publicacao);
		publicacaoService.salvar(publicacao);

		return publicacaoTO;

	}

}
