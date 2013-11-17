package br.com.webhomebeta.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.CalendarEvent;
import br.com.webhomebeta.entity.EspacoCondominio;
import br.com.webhomebeta.entity.Reserva;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.json.CalendarEventJSON;
import br.com.webhomebeta.service.CalendarEventService;
import br.com.webhomebeta.service.EspacoCondominioServe;
import br.com.webhomebeta.service.UsuarioService;
import br.com.webhomebeta.service.security.UserDetailsImp;

@Controller
public class FullCalendarController {

	@Autowired
	private CalendarEventService calendarEventService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EspacoCondominioServe condominioServe;

	@RequestMapping(value = "home/espaco/id={id}")
	public ModelAndView show(@PathVariable("id") int id, ModelMap model) {
		EspacoCondominio espaco = condominioServe.get(id);
		model.put("usuario", getUsuario());
		model.put("idEspaco", id);
		model.put("espaco", espaco);
		return new ModelAndView("calendar", model);
	}

	@RequestMapping(value = "home/calendar", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	List<CalendarEventJSON> showCalendar(@RequestParam("idEspaco") int id) {
		List<CalendarEvent> calendarEvents = calendarEventService.get(id);
		EspacoCondominio espaco = condominioServe.get(id);
		List<CalendarEventJSON> calendarEventJSONs = new ArrayList<>();
		for (CalendarEvent calendarEvent : calendarEvents) {
			CalendarEventJSON calendarEventJSON = new CalendarEventJSON(
					calendarEvent.getId(), calendarEvent.getTitle(),
					dateToString(calendarEvent.getStart()),
					calendarEvent.isEditable(), espaco.getEspaco());

			calendarEventJSONs.add(calendarEventJSON);
		}

		return calendarEventJSONs;
	}

	@RequestMapping(value = "event/save", method = RequestMethod.POST)
	public String salvar(@RequestParam("idEspaco") int idEspaco,
			@RequestParam("titulo") String titulo,
			@RequestParam("idUser") int idUser, @RequestParam("dia") int dia,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano, @RequestParam("nomeEspaco") String nomeEspaco) {

		Usuario u = usuarioService.getById(idUser);

		DateTime dateTime = new DateTime(ano, mes, dia, 0, 0);

		CalendarEvent calendarEvent = new CalendarEvent();
		calendarEvent.setAprovada(false);
		calendarEvent.setEditable(false);
		calendarEvent.setIdEspaco(idEspaco);
		calendarEvent.setIdUser(idUser);
		calendarEvent.setTitle(titulo);
		calendarEvent.setStart(dateTime.toDate());
		calendarEvent.setNome(u.getNome());
		calendarEvent.setNomeEspaco(nomeEspaco);
		

		calendarEventService.save(calendarEvent);

		return "redirect:/home/listarEspaco";
	}

	@RequestMapping(value = "admin/reservas", method = RequestMethod.GET)
	public ModelAndView showReservas(ModelMap model) {
		List<CalendarEventJSON> eventJSONs = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (CalendarEvent reservas : calendarEventService.getAll()) {
			CalendarEventJSON calendarEventJSON = new CalendarEventJSON(
					reservas.getId(), reservas.getTitle(), df.format(reservas
							.getStart()), reservas.isEditable(),
					reservas.getNomeEspaco(), reservas.getNome(), reservas.getIdUser(), reservas.isAprovada());
			eventJSONs.add(calendarEventJSON);
		}

		model.put("reservas", eventJSONs);
		model.put("usuario", getUsuario());
		return new ModelAndView("listReserva", model);
	}
	
	@RequestMapping(value = "admin/reservas/ativar")
	public @ResponseBody String aceitarReserva(@RequestParam("idReserva") int id,@RequestParam("ativa") boolean ativa){
			calendarEventService.update(id, ativa);
			return "true";
	}
	@RequestMapping(value = "admin/reservas/deletar")
	public @ResponseBody String excluir(@RequestParam("idReserva") int id){
		
		calendarEventService.delete(id);
		return "true";
	}
	@RequestMapping(value = "admin/reservas/historico/id={id}", method = RequestMethod.GET)
	public ModelAndView historico(@PathVariable("id") int id, ModelMap model){
		List<CalendarEventJSON> eventJSONs = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for (CalendarEvent reservas : calendarEventService.getAll()) {
			CalendarEventJSON calendarEventJSON = new CalendarEventJSON(
					reservas.getId(), reservas.getTitle(), df.format(reservas
							.getStart()), reservas.isEditable(),
					reservas.getNomeEspaco(), reservas.getNome(), reservas.getIdUser(), reservas.isAprovada());
			eventJSONs.add(calendarEventJSON);
		}
		
		model.put("reservas", eventJSONs);
		model.put("usuario", getUsuario());
		
		return new ModelAndView("historicoMorador",model);
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

	public String dateToString(Date date) {
		DateTime time = new DateTime(date);
		return time.toString(DateTimeFormat
				.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z"));
	}

}
