package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.CalendarEvent;

public interface CalendarEventDAO {

	public CalendarEvent save(CalendarEvent calendarEvent);
	public CalendarEvent get(int id);
	public List<CalendarEvent> get();
	public void delete(CalendarEvent event);
		
}
