package br.com.webhomebeta.controller;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.webhomebeta.entity.CalendarEvent;
import br.com.webhomebeta.json.CalendarEventJSON;
import br.com.webhomebeta.service.CalendarEventService;

@Controller
public class FullCalendarController {

	@Autowired
	private CalendarEventService calendarEventService;

	@RequestMapping(value = "home/calendar", method = RequestMethod.GET)
	public ModelAndView showCalendar() {
		return new ModelAndView("calendar");
	}

	@RequestMapping(value = "event/save", method = RequestMethod.POST)
	public String salvar(@RequestParam("idEspaco") int idEspaco,
			@RequestParam("titulo") String titulo,
			@RequestParam("idUser") int idUser, @RequestParam("dia") int dia,
			@RequestParam("mes") int mes, @RequestParam("ano") int ano) {

		DateTime dateTime = new DateTime(ano, mes, dia, 0, 0);

		CalendarEvent calendarEvent = new CalendarEvent();
		calendarEvent.setAprovada(false);
		calendarEvent.setEditable(false);
		calendarEvent.setIdEspaco(idEspaco);
		calendarEvent.setIdUser(idUser);
		calendarEvent.setTitle(titulo);
		calendarEvent.setStart(dateTime.toDate());

		calendarEventService.save(calendarEvent);

		return "redirect:/WebHomeBeta/home/calendar";
	}

	@RequestMapping(value = "event/id={id}", method = RequestMethod.GET)
	public @ResponseBody
	List<CalendarEventJSON> feedCalender(@PathVariable("id") int idEspaco) {

		List<CalendarEventJSON> calendarEventJSONs = new ArrayList<>();
		
		for(CalendarEvent event : calendarEventService.getEventos(idEspaco)){
			CalendarEventJSON calendarEventJSON = new CalendarEventJSON();
			calendarEventJSON.setEditable(event.isEditable());
			calendarEventJSON.setId(event.getId());
			calendarEventJSON.setStart(dateToString(event.getStart()));
			calendarEventJSON.setTitle(event.getTitle());
			
			calendarEventJSONs.add(calendarEventJSON);
		}
			
		return calendarEventJSONs;
	}

	public String dateToString(Date date) {
		DateTime time = new DateTime(date);
		return time.toString(DateTimeFormat
				.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z"));
	}

}
