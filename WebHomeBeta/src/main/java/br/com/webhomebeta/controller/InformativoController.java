package br.com.webhomebeta.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	@RequestMapping(value = "home/informativo", method = RequestMethod.GET)
	public ModelAndView Atas(ModelMap model) {
		List<Informativo> getList = informativoService.getList();
		model.put("listainformativo", getList);
		model.put("usuario", getUsuario());

		return new ModelAndView("informativo", model);

	}

	public ModelAndView meusInformativos(ModelMap model) {
		Usuario usuario = getUsuario();
		model.put("usuario", usuario);
		model.put("informativos",
				informativoService.getListInformativos(usuario.getIdUser()));
		return new ModelAndView("meusInformativos", model);
	}

	@RequestMapping(value = "home/novoInformativo")
	public ModelAndView novoInformativo(ModelMap model) {
		model.put("iformativo", informativoBean);
		model.put("usuario", getUsuario());
		return new ModelAndView("novoInformativo", model);
	}

	@RequestMapping(value = "home/novoInformativo/salvar", method = RequestMethod.POST)
	public String salvarInformativo(
			@ModelAttribute("bean") InformativoBean bean, BindingResult result) {
		Informativo informativo = new Informativo();
		BeanUtils.copyProperties(bean.getInformativoTO(), informativo);
		Date hoje = new Date();
		int diasAvancar = 60;
		Date novaData = new Date(hoje.getTime()
				+ ((1000 * 24 * 60 * 60) * diasAvancar));
		bean.getInformativoTO().setDataExpiracao(novaData);
		informativoService.save(informativo);

		bean.getInformativoTO().setDataPublicaco(null);
		bean.getInformativoTO().setEmail(null);
		bean.getInformativoTO().setInformativo(null);
		bean.getInformativoTO().setNomeUser(null);

		return "redirect:/home/informativo";
	}

	@RequestMapping(value = "home/informativo/delete", method = RequestMethod.POST)
	public String delete(
			@ModelAttribute("informativo") Informativo informativo,
			BindingResult result, InformativoBean bean) {

		informativoService.delete(informativo);

		return "redirect:/inserirAtas/delete";
	}

	//deleta uma data quando vencer por 60 dias
	@Scheduled(fixedRate = 86400000)
	public void expirar() {
		Date date = new Date();
		List<Informativo> expirar = informativoService.getList();
		for (Informativo informativo : expirar) {
			if (informativo.getDataExpiracao().after(date)) {
				informativoService.delete(informativo);

			}
		}

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
