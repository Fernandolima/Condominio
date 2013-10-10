package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Opcode;

import org.apache.commons.collections.functors.IfClosure;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.handlers.message_rfc822;

import br.com.webhomebeta.bean.EnquetesControllerBean;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.OpcaoVotada;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EnquetesService;
import br.com.webhomebeta.service.OpcaoService;
import br.com.webhomebeta.service.OpcaoVotadaService;
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
	@Autowired
	private OpcaoVotadaService opcaoVotadaService;
	@Autowired
	private OpcaoService opcaoService;

	// mapeia a URL principal (Enquetes) e retorna um novo objeto
	@RequestMapping(value = "admin/enquetes", method = RequestMethod.GET)
	public ModelAndView enquetes(ModelMap model) {

		model.put("usuario", getUsuario());
		model.put("bean", enquetesControllerBean);

		return new ModelAndView("enquetes", model);
	}

	// mapeia a URL principal (Enquetes) e retorna um novo objeto
	@RequestMapping(value = "admin/listaEnquetes", method = RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.put("listaEnquetes", enquetesService.getList());
		model.put("usuario", getUsuario());

		return new ModelAndView("listaEnquetes", model);

	}

	@RequestMapping(value = "listaEnqutesAtivas", method = RequestMethod.GET)
	public ModelAndView listaEnquete(ModelMap modelMap) {
		modelMap.put("listaEnquete", enquetesService.getListAtiva(true));

		return new ModelAndView("listaEnquetesAtiva", modelMap);

	}

	// tati vai passa a string com as opcoes
	@RequestMapping(value = "admin/enquetes/salvar", method = RequestMethod.POST)
	public String salvarEnquete(
			@ModelAttribute("bean") EnquetesControllerBean bean,
			BindingResult result) {
		// criar a data da enquete
		bean.getEnquetesTo().setDataequete(new Date());
		bean.getEnquetesTo().setUsuarioEnquete(getUsuario());
		Enquetes enquetes = new Enquetes();
		BeanUtils.copyProperties(bean.getEnquetesTo(), enquetes);
		List<Opcao> opcao = new ArrayList<>();
		// adiocina as opcoes para a enqueteto
		for (String opcaos : bean.getListOpcoes()) {

			opcao.add(new Opcao(opcaos, enquetes));

		}

		enquetes.setOpcao(opcao);
		enquetesService.save(enquetes);

		return "redirect:/enquetes";
	}

	@RequestMapping(value = "computarVoto", method = RequestMethod.POST)
	public @ResponseBody
	String computarVoto(@RequestParam("idUser") int idUser,
			@RequestParam("idOpcao") int idOpcao,
			@RequestParam("idEnquete") int idEnquete) {
		OpcaoVotada opcaoVotada = new OpcaoVotada(new Opcao(idOpcao), idUser);
		if (idUser == getUsuario().getIdUser()) {
			opcaoVotadaService.save(opcaoVotada);

			return "true";

		}

		opcaoService.update(1, idOpcao);
		enquetesService.update(1, idEnquete);

		return "true";
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

	@RequestMapping(value = "admin/enquetes/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("idEnquete") int idEnquete) {

		Enquetes enquete = enquetesService.get(idEnquete);
		enquetesService.delete(enquete);

		return "redirect:enquetes";
	}

}
