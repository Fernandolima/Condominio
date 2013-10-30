package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import br.com.webhomebeta.json.UsuarioJSON;
import br.com.webhomebeta.service.EmailServico;
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
	@Autowired
	private EmailServico emailServico;

	@RequestMapping(value = "admin/enquete?id={id}", method = RequestMethod.GET)
	public @ResponseBody
	EnqueteJSON showEnquete(@PathVariable("id") int id) {
		Enquetes e = enquetesService.get(id);
		ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
		int totalVotos = e.getTotalVotos();
		EnqueteJSON enqueteJSON = new EnqueteJSON(e.getTitulo(),
				e.getIdEquete(), e.getUsuarioEnquete().getIdUser(),
				e.getTotalVotos());
		for (Opcao o : e.getOpcao()) {
			DecimalFormat f = new DecimalFormat("##.##");
			OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(), o.getOpcao(),
					f.format(((o.getQuatVots() * 100d) / totalVotos)));
			opcaoJSONs.add(opcaoJSON);
		}
		enqueteJSON.setOpcoes(opcaoJSONs);

		return enqueteJSON;
	}

	public List<EnqueteJSON> loadEnquetes() {
		List<Enquetes> enquetes = enquetesService.getListAtiva(true);
		ArrayList<EnqueteJSON> enqueteJSONs = new ArrayList<>();
		for (Enquetes e : enquetes) {
			int totalVotos = e.getTotalVotos();
			ArrayList<OpcaoJSON> opcaoJSONs = new ArrayList<>();
			EnqueteJSON enqueteJSON = new EnqueteJSON(e.getTitulo(),
					e.getIdEquete(), e.getUsuarioEnquete().getIdUser(),
					e.getTotalVotos());
			for (Opcao o : e.getOpcao()) {
				DecimalFormat f = new DecimalFormat("##.##");
				OpcaoJSON opcaoJSON = new OpcaoJSON(o.getIdOpcao(),
						o.getOpcao(), f.format(((o.getQuatVots() * 100d) / totalVotos)));
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
		model.put("enquetes", loadEnquetes());
		bean.setUsuario(getUsuario());

		return new ModelAndView("admin", model);
	}

	@RequestMapping(value = "admin/validarMoradores")
	public ModelAndView validarMoradores(ModelMap model) {

		model.put("usuario", getUsuario());

		return new ModelAndView("validarMoradores", "listaUsuarios",
				usuarioService.getUsuarioNaoAtivo());
	}

	@RequestMapping(value = "admin/morador/val={valid}/login={log}/proc")
	public void validar(@PathVariable("valid") boolean valid,
			@PathVariable("log") String log) {
		Usuario usuario = usuarioService.getUsuarioByLogin(log);
		if (valid) {
			usuarioService.update(usuario.getIdUser(), valid);
			emailServico.emailNovoMoradorAceito(usuario);
		} else {
			emailServico.emailMoradorNaoAceito(usuario);
		}

	}

	// Recebe como parametro o id do usuario e devolve o usuario com todas as
	// informacoes
	@RequestMapping(value = "	admin/validarMoradores/login={login}/proc")
	public ModelAndView editarUsuario(@PathVariable("login") String login, ModelMap map) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Usuario usuario = usuarioService.getUsuarioByLogin(login);
		UsuarioJSON usuarioJSON = new UsuarioJSON(usuario.getNome(),
				df.format(usuario.getDt_nascimento()), usuario.getCpf(),
				usuario.getEmail(), usuario.getAp(), usuario.getBloco(),
				usuario.getIdUser());
		map.put("usuarioValidar", usuarioJSON);
		map.put("usuario", getUsuario());
		return new ModelAndView("editarCadastro", map);
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
