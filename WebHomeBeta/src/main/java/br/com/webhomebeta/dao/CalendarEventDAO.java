package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.CalendarEvent;

public interface CalendarEventDAO {

	public CalendarEvent save(CalendarEvent calendarEvent);
	public List<CalendarEvent> get(int id);
	public List<CalendarEvent> getEventos(int id);
	public List<CalendarEvent> get();
	public List<CalendarEvent> getAll();
	public List<CalendarEvent> getHistorico(int idUser);
	public void delete(int id);
	public void update(int idEspaco, boolean ativa);
		
}
