package br.com.webhomebeta.controller;

import java.util.Date;

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
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.EnquetesControllerBean;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EnquetesService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class EnquetesController {
	@Autowired
	private EnquetesService enquetesService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EnquetesControllerBean enquetesControllerBean;

	// mapeia a URL principal (Enquetes) e retorna um novo objeto atas
	@RequestMapping(value = "enquetes", method = RequestMethod.GET)
	public ModelAndView Enquetes(ModelMap model) {

		model.put("listaEnquetes", enquetesService.getList());
		model.put("usuario", getUsuario());
		model.put("bean", enquetesControllerBean);

		return new ModelAndView("enquetes", model);
	}

	// tati vai passa a string com as opcoes
	@RequestMapping(value = "enquetes/salvar", method = RequestMethod.POST)
	public String salvarEnquete(
			@ModelAttribute("bean") EnquetesControllerBean bean,
			BindingResult result) {
		//criar a data da enquete
		bean.getEnquetesTo().setDataequete(new Date());
		bean.getEnquetesTo().setUsuarioEnquete(getUsuario());
		// adiocina as opcoes para a enqueteto
		for (String opcao : bean.getListOpcoes()) {

			bean.getEnquetesTo().addOpcao(new Opcao(opcao));

		}
		
		Enquetes enquetes = new Enquetes();
		BeanUtils.copyProperties(bean.getEnquetesTo(), enquetes);
		enquetesService.save(enquetes);
		
		return "redirect:/enquetes";
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
	
	@RequestMapping(value = "enquetes/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("enquetes") Enquetes enquetes,
			BindingResult result) {
		enquetesService.delete(enquetes);

		return "redirect:/inserirAtas/delete";
	}


}
