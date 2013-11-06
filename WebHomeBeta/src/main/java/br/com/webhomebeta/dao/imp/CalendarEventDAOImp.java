package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.CalendarEventDAO;
import br.com.webhomebeta.entity.CalendarEvent;

public class CalendarEventDAOImp implements CalendarEventDAO {

	@Autowired
	private SessionFactory factory;
	@Override
	public CalendarEvent save(CalendarEvent calendarEvent) {
		factory.getCurrentSession().save(calendarEvent);
		return calendarEvent;
	}

	@Override
	public CalendarEvent get(int id) {
		return (CalendarEvent) factory.getCurrentSession().get(CalendarEvent.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CalendarEvent> get() {
		return factory.getCurrentSession().createQuery("from CalendarEvent").list();
	}

	@Override
	public void delete(CalendarEvent event) {
		factory.getCurrentSession().delete(event);
		
	}

}
