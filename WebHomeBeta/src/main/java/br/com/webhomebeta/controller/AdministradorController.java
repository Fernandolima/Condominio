package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.DadosUsuarioBean;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.EnqueteJSON;
import br.com.webhomebeta.json.OpcaoJSON;
import br.com.webhomebeta.service.EnquetesService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class AdministradorController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private DadosUsuarioBean bean;
	@Autowired
	private EnquetesService enquetesService;

	@RequestMapping(value = "loadEnquetes", method = RequestMethod.POST)
	public @ResponseBody
	List<EnqueteJSON> loadEnquetes() {
		List<Enquetes> enquetes = enquetesService.getListAtiva(true);
		ArrayList<EnqueteJSON> enqueteJSONs = new ArrayList<>();
		ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
		for (Enquetes e : enquetes) {
			EnqueteJSON enqueteJSON = new EnqueteJSON(e.getTitulo(),
					e.getIdEquete(), e.getUsuarioEnquete().getIdUser(),e.getTotalVotos());
			for (Opcao o : e.getOpcao()) {
				OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(),
						o.getOpcao(), o.getQuatVots());
				opcaoJSONs.add(opcaoJSON);
			}
			enqueteJSON.setOpcoes(opcaoJSONs);
			enqueteJSONs.add(enqueteJSON);
		}
		return enqueteJSONs;
	}

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public ModelAndView show(ModelMap model) {

		List<Enquetes> enquetes = enquetesService.getListAtiva(true);

		bean.setUsuario(getUsuario());

		long validarModadores = usuarioService.getRowCount(false);

		model.put("enquetes", enquetes);

		model.put("dadosUsuarioBean", bean);
		model.put("usuario", getUsuario());
		model.put("validarMoradores", validarModadores);
		bean.setUsuario(getUsuario());

		return new ModelAndView("admin", model);
	}

	@RequestMapping(value = "admin/validarMoradores")
	public ModelAndView validarMoradores() {

		return new ModelAndView("validarMoradores", "listaUsuarios",
				usuarioService.getUsuarioNaoAtivo());
	}

	// Recebe como parametro o id do usuario e devolve o usuario com todas as
	// informacoes
	@RequestMapping(value = "admin/editarCadastro")
	public ModelAndView editarUsuario(@RequestParam("id") int id) {

		return new ModelAndView("admin/editarCadastro", "usuario",
				usuarioService.getById(id));
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
