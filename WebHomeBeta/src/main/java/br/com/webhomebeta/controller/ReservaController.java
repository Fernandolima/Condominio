package br.com.webhomebeta.controller;

import java.util.List;


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
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.bean.ReservaControllerBean;
import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.service.CalendarEventService;
import br.com.webhomebeta.service.EmailServico;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.ReservaService;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;
import br.com.webhomebeta.entity.Reserva;


@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	@Autowired
	private CalendarEventService calendarEventService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;
	@Autowired
	private EspacoCondominioServe espacoCondominioServe;
	@Autowired
	private EspacoCondominioController espacoCondominioController;
	@Autowired
	private ReservaControllerBean reservaControllerBean;
	
	@RequestMapping(value = "home/reserva/cancelar={id}", method = RequestMethod.GET)
	public boolean cancelarReserva(@PathVariable("id") int idReserva){
		Reserva reserva = reservaService.get(idReserva);
		if(reserva.getIdUser() == getUsuario().getIdUser()){
			reservaService.delete(reserva);
			return true;
		}else{
			return false;
		}
	}

	// mapeia a URL principal (Reserva) e retorna um novo objeto
	@RequestMapping(value = "home/listarEspacos", method = RequestMethod.GET)
	public ModelAndView listaEspaco(ModelMap model) {
		model.put("usuario", getUsuario());
		model.put("listaespacos",
				espacoCondominioServe.getLisEspacoCondominios());

		return new ModelAndView("espacoUsuario", model);

	}

	@RequestMapping(value = "admin/reservas/historico={id}", method = RequestMethod.GET)
	public ModelAndView historico(@PathVariable("id") int idUser, ModelMap model){
		List<Reserva> historicoReserva = reservaService.getHistorico(idUser);
		model.put("historicoReservas", historicoReserva);
		return new ModelAndView("historicoReserva", model);
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
