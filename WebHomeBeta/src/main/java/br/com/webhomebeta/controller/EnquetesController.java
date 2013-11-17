package br.com.webhomebeta.controller;

import java.text.DecimalFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import br.com.webhomebeta.json.EnqueteJSON;
import br.com.webhomebeta.json.Json;
import br.com.webhomebeta.json.OpcaoJSON;
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

	@RequestMapping(value = "admin/visualizar/id={id}", method = RequestMethod.GET)
	public ModelAndView visualizarEnquete(@PathVariable("id") int idEnquete) {
		return new ModelAndView("visualizarEnquete", "enquete",
				enquetesService.get(idEnquete));
	}

	@RequestMapping(value = "admin/enquetes/ativar")
	public @ResponseBody
	String ativarEnquete(@RequestParam("idEnquete") int idEnquete,
			@RequestParam("ativa") boolean ativa) {
		enquetesService.update(idEnquete, ativa);
		return "true";
	}

	@RequestMapping(value = "listaEnqutesAtivas", method = RequestMethod.GET)
	public ModelAndView listaEnquete(ModelMap modelMap) {
		modelMap.put("listaEnquete", enquetesService.getListAtiva(true));

		return new ModelAndView("listaEnquetesAtiva", modelMap);

	}

	@RequestMapping(value = "admin/enquetes/editar/id={id}")
	public ModelAndView editarEnquete(@PathVariable("id") int id, ModelMap model){
		EnquetesControllerBean bean = new EnquetesControllerBean();
		Enquetes enquetes = enquetesService.get(id);
		BeanUtils.copyProperties(enquetes, bean.getEnquetesTo());
		
		if(enquetes.getTotalVotos() > 0){
			model.put("listaEnquetes", enquetesService.getList());
			model.put("usuario", getUsuario());
			int erro = 1;
			model.put("erro", erro);
			return new ModelAndView("listaEnquetes", model);
		}
		List<String> opcaos = new ArrayList<>();
		for(Opcao opcao : enquetes.getOpcao()){
			opcaos.add(opcao.getOpcao());
			System.out.println(opcao.getOpcao());
		}
		bean.setListOpcoes(opcaos);
		model.put("bean", bean);
		return new ModelAndView("editarEnquete", model);
	}
	
	
	@RequestMapping(value = "admin/enquetes/editar", method = RequestMethod.POST)
	public String editarEnquete(
			@ModelAttribute("bean") EnquetesControllerBean bean,
			BindingResult result) {
		
		Enquetes enquetes = enquetesService.get(bean.getEnquetesTo().getIdEquete());
		List<Opcao> opcoes = enquetes.getOpcao();

		//Variavel aux
		int aux = 0;
		for(int i = 0; i < opcoes.size(); i++){
			String o = bean.getListOpcoes().get(i);
			Opcao op = opcoes.get(i);
			op.setOpcao(o);
			System.out.println("Nova opcao " + op.getOpcao());
			aux++;
		}
		if(aux != bean.getListOpcoes().size()){
			for(int i = aux; i < bean.getListOpcoes().size(); i ++){
				Opcao op = new Opcao(bean.getListOpcoes().get(i), enquetes);
				opcoes.add(op);
			}
		}
		enquetes.setOpcao(opcoes);
		enquetesService.update(enquetes);

		return "redirect:/admin/enquetes";
	}
	
	@RequestMapping(value = "admin/enquetes/salvar", method = RequestMethod.POST)
	public @ResponseBody Json salvarEnquete(
			@ModelAttribute("bean") EnquetesControllerBean bean,
			BindingResult result) {
		if(bean.getListOpcoes().contains("") || bean.getEnquetesTo().getEquete().equals("")){
			return new Json("false");
		}
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

		return new Json("true");
	}


	
	@RequestMapping(value = "computarVoto", method = RequestMethod.POST)
	public @ResponseBody
	EnqueteJSON computarVoto(@RequestParam("idUser") int idUser,
			@RequestParam("idOpcao") int idOpcao,
			@RequestParam("idEnquete") int idEnquete) {
		Opcao opcao = opcaoService.get(idOpcao);
		OpcaoVotada opcaoVotada = new OpcaoVotada(opcao, idUser);
		if (idUser == getUsuario().getIdUser()) {
			opcaoVotadaService.save(opcaoVotada);
			opcaoService.update(1, idOpcao);
			enquetesService.update(1, idEnquete);
			
			DecimalFormat f = new DecimalFormat("##.##");
			Enquetes enquetes = enquetesService.get(idEnquete);
			int totalVotos = enquetes.getTotalVotos();
			ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
			EnqueteJSON enqueteJSON = new EnqueteJSON(enquetes.getIdEquete(), enquetes
					.getUsuarioEnquete().getIdUser(), enquetes.getTotalVotos(),
					enquetes.getEnquete());
			for (Opcao o : enquetes.getOpcao()) {
				OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(),
						o.getOpcao(),
						f.format(((o.getQuatVots() * 100d) / totalVotos)));
				for (OpcaoVotada ov : o.getOpcaoVotadas()) {
					enqueteJSON.getIdVoto().add(ov.getIdUser());
				}
				opcaoJSONs.add(opcaoJSON);
			}
			enqueteJSON.setOpcoes(opcaoJSONs);
			
			return enqueteJSON;
		}

		return new EnqueteJSON(true);
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
	public @ResponseBody
	String delete(@RequestParam("idEnquete") int idEnquete) {

		Enquetes enquete = enquetesService.get(idEnquete);
		enquetesService.delete(enquete);

		return "true";
	}

}
