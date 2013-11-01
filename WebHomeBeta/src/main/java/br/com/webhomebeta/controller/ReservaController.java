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
	private UsuarioService usuarioService;
	@Autowired
	private EmailServico emailServico;
	@Autowired
	private EspacoCondominioServe espacoCondominioServe;
	@Autowired
	private EspacoCondominioController espacoCondominioController;
	@Autowired
	private ReservaControllerBean reservaControllerBean;

	// mapeia a URL principal (Reserva) e retorna um novo objeto Reserva
	@RequestMapping(value = "home/reserva", method = RequestMethod.GET)
	public ModelAndView reserva(ModelMap model) {

		model.put("usuario", getUsuario());
		model.put("bean", reservaControllerBean);
		model.put("listaReserva",
				espacoCondominioServe.getLisEspacoCondominios());
		return new ModelAndView("reserva", model);
	}

	@RequestMapping(value = "home/reserva/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("reserva") Reserva reserva,
			BindingResult result) {
		reservaService.delete(reserva);

		return "redirect:/home/reserva";
	}

	// mapeia a URL principal (Reserva) e retorna um novo objeto
	@RequestMapping(value = "home/salvaReserva", method = RequestMethod.GET)
	public boolean listaReserva(@RequestParam("data") String dataPreReserva,
			@RequestParam("reserva") String nomeReserva,
			@RequestParam("nome") String nome,
			@RequestParam("idUser") int idUser,
			@RequestParam("idEspaco") int idEspaco) {

		EspacoCondominio espaco = espacoCondominioServe.get(idEspaco);

		for (Reserva r : reservaService.getLisReservas())
			if (r.getPreReserva() == dataPreReserva && r.getEspacoCondominio().getEspaco().equals(nomeReserva))
				return false;

		Reserva reserva = new Reserva(nomeReserva, dataPreReserva, idUser,
				nome, espaco, false);
		emailServico.emailNovoEspacoReservado(getUsuario(), reserva);
		reservaService.save(reserva);
		return true;

	}
	
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
		model.put("listaespacos",
				espacoCondominioServe.getLisEspacoCondominios());

		return new ModelAndView("listaespacos", model);

	}

	@RequestMapping(value = "admin/reservas", method = RequestMethod.GET)
	public ModelAndView showReservas(ModelMap model) {
		List<Reserva> reservas = reservaService.getLisReservas();
		model.put("reservas", reservas);
		model.put("usuario", getUsuario());
		return new ModelAndView("listReserva", model);

	}
	
	@RequestMapping(value = "admin/reservas/aceitar={bol}/id={id}")
	public boolean aceitarReserva(@PathVariable("bol") boolean ativa, @PathVariable("id") int id){
		if(ativa){
			reservaService.update(id, ativa);
			return true;
		}else{
			Reserva reserva = reservaService.get(id);
			reservaService.delete(reserva);
			return true;
		}
	}
	
//	@RequestMapping(value = "admin/reservas/id={id}", method = RequestMethod.GET)
//	public ModelAndView decidirReserva(@PathVariable("id") int idReserva, ModelMap model){
//		Reserva reserva = reservaService.get(idReserva);
//		model.put("reserva", reserva);
//		return new ModelAndView("visualizaReserva", model);
//	}
	
	@RequestMapping(value = "admin/reservas/historico={id}", method = RequestMethod.GET)
	public ModelAndView historico(@PathVariable("id") int idUser, ModelMap model){
		List<Reserva> historicoReserva = reservaService.getHistorico(idUser);
		model.put("historicoReservas", historicoReserva);
		return new ModelAndView("historicoReserva", model);
	}

	// @RequestMapping(value = "home/reserva/salvar", method =
	// RequestMethod.POST)
	// public String salvarReserva(
	// @ModelAttribute("bean") ReservaControllerBean bean,
	// BindingResult result) {
	// // criar a data da enquete
	// for (String reserva : bean.getListReserva()) {
	// // split divide a string em pedaços
	// String pedaco[] = reserva.split(",");
	//
	// Reserva reservaa = new Reserva(pedaco[0], new Date(pedaco[1]),
	// getUsuario().getNome());
	//
	// reservaService.save(reservaa);
	// }
	//
	// return "redirect:/home/reserva";
	// }

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
