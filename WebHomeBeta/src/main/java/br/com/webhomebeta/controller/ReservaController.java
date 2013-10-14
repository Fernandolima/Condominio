package br.com.webhomebeta.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Parent;
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
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.ReservaControllerBean;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.ReservaService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.to.ReservaTO;
import br.com.webhomebeta.validacao.ValidadorEspaco;
import br.com.webhomebeta.entity.Reserva;

;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EspacoCondominioServe espacoCondominioServe;
	@Autowired
	private EspacoCondominioController espacoCondominioController;
	@Autowired
	private ReservaControllerBean reservaControllerBean;

	private ValidadorEspaco ValidadorEspaco = new ValidadorEspaco();

	private Reserva reserva;

	// mapeia a URL principal (Reserva) e retorna um novo objeto Reserva
	@RequestMapping(value = "reserva", method = RequestMethod.GET)
	public ModelAndView reserva(ModelMap model) {

		model.put("usuario", getUsuario());
		model.put("bean", reservaControllerBean);
		model.put("listaReserva",
				espacoCondominioServe.getLisEspacoCondominios());
		return new ModelAndView("reserva", model);
	}

	@RequestMapping(value = "reserva/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("reserva") Reserva reserva,
			BindingResult result) {
		reservaService.delete(reserva);

		return "redirect:/reserva";
	}

	// mapeia a URL principal (Reserva) e retorna um novo objeto
	@RequestMapping(value = "salvaReserva", method = RequestMethod.GET)
	public boolean listaReserva(@RequestParam("data") Date date,
			@RequestParam("nome") String nome,
			@RequestParam("idUser") int idUser) {

		for (Reserva reserva : reservaService.getLisReservas()) {

			if (reserva.getDateReserva() == date) {
				return false;
			} else {
				reserva.getDateReserva();
				reservaService.save(reserva);
			}

		}
		return true;

	}

	// mapeia a URL principal (Reserva) e retorna um novo objeto
	@RequestMapping(value = "listaespacos", method = RequestMethod.GET)
	public ModelAndView listaEspaco(ModelMap model) {
		model.put("listaespacos",
				espacoCondominioServe.getLisEspacoCondominios());

		return new ModelAndView("listaespacos", model);

	}

	@RequestMapping(value = "reserva/salvar", method = RequestMethod.POST)
	public String salvarReserva(
			@ModelAttribute("bean") ReservaControllerBean bean,
			BindingResult result) {
		// criar a data da enquete
		for (String reserva : bean.getListReserva()) {
			// split divide a string em pedaços
			String pedaco[] = reserva.split(",");

			Reserva reservaa = new Reserva(pedaco[0], new Date(pedaco[1]),
					getUsuario().getNome());

			reservaService.save(reservaa);
		}

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

}
