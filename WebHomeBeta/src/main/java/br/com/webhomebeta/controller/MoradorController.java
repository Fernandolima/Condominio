package br.com.webhomebeta.controller;

import java.util.Collections;
import java.util.List;

import javax.naming.Binding;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Publicacao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.ComentarioService;
import br.com.webhomebeta.service.PublicacaoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.to.PublicacaoTO;

@Controller
@SessionAttributes("usuarioNaSessao")
public class MoradorController {
	
	private Usuario usuarioNaSessao;
	@Autowired
	private ComentarioService comentarioService;
	@Autowired
	private PublicacaoService publicacaoService;
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "publicar", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model){
		List<Publicacao> publicacoes = publicacaoService.getPublicacoes();
		Collections.reverse(publicacoes);
		model.put("listaPublicacoes", publicacoes);
		model.put("publicacaoTO", new PublicacaoTO());
//		usuarioNaSessao = new Usuario();
//		SecurityContext context = SecurityContextHolder.getContext();
//		if (context instanceof SecurityContext) {
//			Authentication authentication = context.getAuthentication();
//			if (authentication instanceof Authentication) {
//				usuarioNaSessao = usuarioService
//						.getUsuarioByLogin(((User) authentication
//								.getPrincipal()).getUsername());
//
//			}
//		}
		return new ModelAndView("publicar",model);
	}
	
	@RequestMapping(value = "salvarPublicacao", method = RequestMethod.POST)
	public String salvarPublicacao(@ModelAttribute("publicacaoTO") PublicacaoTO publicacaoTO, BindingResult bindingResult){
		Usuario u = new Usuario();
		u.setIdUser(1);
		publicacaoTO.setUsuarioPublicacao(u);
		Publicacao p = new Publicacao();
		BeanUtils.copyProperties(publicacaoTO, p);
		publicacaoService.salvar(p);
		return "redirect:/publicar";
		
	}

	
	
}
