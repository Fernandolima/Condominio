package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.CalendarEventDAO;
import br.com.webhomebeta.entity.CalendarEvent;

public class CalendarEventService {

	@Autowired
	private CalendarEventDAO calendarEventDAO;
	
	public CalendarEvent save(CalendarEvent calendarEvent) {
		return calendarEventDAO.save(calendarEvent);
	}

	public CalendarEvent get(int id) {
		return calendarEventDAO.get(id);
	}

	
	public List<CalendarEvent> get() {
		return calendarEventDAO.get();
	}

	public void delete(CalendarEvent event) {
		calendarEventDAO.delete(event);
		
	}

	
}
