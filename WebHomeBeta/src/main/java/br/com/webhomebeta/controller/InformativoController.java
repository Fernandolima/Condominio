package br.com.webhomebeta.controller;

import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.InformativoBean;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Informativo;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.InformativoService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class InformativoController {
	@Autowired
	private InformativoService informativoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private InformativoBean informativoBean;

	// mapeia a URL principal (Atas) e retorna um novo objeto atas
	@RequestMapping(value = "informativo", method = RequestMethod.GET)
	public ModelAndView Atas(ModelMap model) {
		List<Informativo> getList = informativoService.getList();
		model.put("listainformativo", getList);
		model.put("usuario", getUsuario());

		return new ModelAndView("informativo", model);

	}

	@RequestMapping(value = "informativo/salvar", method = RequestMethod.POST)
	public void salvarInformativo(@ModelAttribute("bean") InformativoBean bean,
			BindingResult result) {
		
		Informativo informativo = new Informativo();
		informativo.setDataPublicaco(new Date());
		informativo.setEmail(bean.getInformativoTO().getEmail());
		informativo.setInformativo(bean.getInformativoTO().getInformativo());
		informativo.setNomeUser(bean.getInformativoTO().getNomeUser());
		BeanUtils.copyProperties(bean.getInformativoTO(), informativo);
		informativoService.save(informativo);

		bean.getInformativoTO().setDataPublicaco(null);
		bean.getInformativoTO().setEmail(null);
		bean.getInformativoTO().setInformativo(null);
	}

	@RequestMapping(value = "informativo/delete", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("informativo") Informativo informativo,
			BindingResult result) {
		informativoService.delete(informativo);

		return "redirect:/inserirAtas/delete";
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
