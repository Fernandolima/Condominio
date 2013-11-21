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

	public List<CalendarEvent> get(int id) {
		return calendarEventDAO.get(id);
	}

	
	public List<CalendarEvent> get() {
		return calendarEventDAO.get();
	}

	public void delete(int id) {
		calendarEventDAO.delete(id);
		
	}
	
	public List<CalendarEvent> getEventos(int id){
		return calendarEventDAO.getEventos(id);
	}

	public void update(int idEspaco, boolean ativa) {
		calendarEventDAO.update(idEspaco, ativa);
	}
	
	public List<CalendarEvent> getAll(){
		return calendarEventDAO.getAll();
	}
	public List<CalendarEvent> getHistorico(int idUser){
		return calendarEventDAO.getHistorico(idUser);
	}
	
	public CalendarEvent getEvent(int id){
		return calendarEventDAO.getEvent(id);
	}
	
	public long getRowCount(boolean b){
		return calendarEventDAO.getRowCount(b);
	}
}
