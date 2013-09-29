package br.com.webhomebeta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EnquetesService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.EnquetesTo;

public class EnquetesController {
	@Autowired
	private EnquetesService enquetesService;
	private EnquetesTo enquetesTo;
	@Autowired
	private UsuarioService usuarioService;

	// mapeia a URL principal (Enquetes) e retorna um novo objeto atas
	@RequestMapping(value = "enquetes", method = RequestMethod.GET)
	public ModelAndView Enquetes(ModelMap model) {

		model.put("enqueteTO", new EnquetesTo());
		model.put("listaEnquetes", enquetesService.getList());
		model.put("usuario", getUsuario());
		return new ModelAndView("enquetes", model);
	}

	@RequestMapping(value = "enquetes/salvar", method = RequestMethod.POST)
	public void salvarEnquete(
			@ModelAttribute("enqueteTO") EnquetesTo enquetesTo,
			BindingResult result) {
		

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
