package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.MuralService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.MuralTO;


@Controller
public class MuralController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MuralService muralService;
	@Autowired
	private DadosUsuarioBean bean;
	
	@RequestMapping(value = "mural", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model){
		bean.setUsuario(getUsuario());
		model.put("mural", new MuralTO());
		model.put("usuario", bean);
		return new ModelAndView("mural",model);
	}
	
	@RequestMapping(value = "mural/save", method = RequestMethod.POST)
	public void save(){
		
	}
	
	public Usuario getUsuario() {

		Usuario usuario = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			// Pega as informacoes da autenticacao
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof Authentication) {
				// Pega o usuario que logou
				usuario = usuarioService
						.getUsuarioByLogin(((UserDetailsImp) authentication
								.getPrincipal()).getUsername());

			}
		}

		return usuario;
	}
	
}
