package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.VisitanteBean;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.entity.Visitante;
import br.com.webhomebeta.json.UsuarioJSON;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.VisitanteService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class VisitanteConller {
	@Autowired
	private VisitanteService service;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private VisitanteService visitanteService;
	@Autowired
	private VisitanteBean visitanteBean;

	// mapeia a URL principal (visitantes) e retorna um novo objeto visitante para listar os visitantes
	@RequestMapping(value = "admin/visitante", method = RequestMethod.GET)
	public ModelAndView listaVisitantes(ModelMap model) {
		List<Visitante> visitantes = visitanteService.getVisitantes();
		model.put("usuario", getUsuario());
		model.put("listaVisitantes", visitantes);
		// Lista os visitantes.
		return new ModelAndView("listaDeVisitantes", model);

	}


	// mapeia a URL principal (visitantes) e retorna um novo objeto visitantes para cadastrar os visitantes
	@RequestMapping(value = "admin/cadastrar/visitantes", method = RequestMethod.GET)
	public ModelAndView visitantes(ModelMap model) {
		model.put("bean", visitanteBean);
		model.put("usuario", getUsuario());
		// cadastra os visitantes.
		return new ModelAndView("visitantes", model);

	}

	@RequestMapping(value = "admin/verificarAp", method = RequestMethod.GET)
	public @ResponseBody
	List<UsuarioJSON> Atas(@RequestParam("bloco") String bloco,
			@RequestParam("ap") String ap) {
		List<Usuario> listaBlocoAp = visitanteService.getList(bloco, ap);
		// cria uma array UsuarioJson
		ArrayList<UsuarioJSON> json = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (Usuario usuario : listaBlocoAp) {
			UsuarioJSON usuarioJSON = new UsuarioJSON(usuario.getNome(),
					df.format(usuario.getDt_nascimento()), usuario.getCpf(),
					usuario.getEmail(), usuario.getAp(), usuario.getBloco(),
					usuario.getIdUser());
			json.add(usuarioJSON);

		}

		return json;
	}

	@RequestMapping(value = "admin/visitante/salvar", method = RequestMethod.GET)
	public String salvarVisitante(@ModelAttribute("bean") BindingResult result,
			VisitanteBean bean) {
		Visitante visitante = new Visitante();
		BeanUtils.copyProperties(bean.getVisitanteTO(), visitante);
		visitanteService.save(visitante);
		bean.getVisitanteTO().setAp(null);
		bean.getVisitanteTO().setBloco(null);
		bean.getVisitanteTO().setData(null);
		bean.getVisitanteTO().setNomeVisitante(null);
		bean.getVisitanteTO().setPlacaDoCarro(null);
		bean.getVisitanteTO().setRg(null);

		return "redirect:/admin/visitantes";
	}

	@RequestMapping(value = "admin/visitante/delete/id={id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		
		visitanteService.delete(id);

		return "redirect:/admin/visitante";
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
