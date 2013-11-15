package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.CalendarEventDAO;
import br.com.webhomebeta.entity.CalendarEvent;

public class CalendarEventDAOImp implements CalendarEventDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public CalendarEvent save(CalendarEvent calendarEvent) {
		factory.getCurrentSession().save(calendarEvent);
		return calendarEvent;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CalendarEvent> get(int id) {
		return factory.getCurrentSession().createQuery("from CalendarEvent event where event.idEspaco = ?").setInteger(0, id).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CalendarEvent> get() {
		return factory.getCurrentSession().createQuery("from CalendarEvent event where event.aprovada = True")
				.list();
	}

	@Override
	@Transactional
	public void delete(CalendarEvent event) {
		factory.getCurrentSession().delete(event);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CalendarEvent> getEventos(int id) {
		return factory.getCurrentSession()
				.createQuery("from CalendarEvent event where event.id = ?")
				.setInteger(0, id).list();
	}

	@Override
	@Transactional
	public void update(int idEspaco) {
		factory.getCurrentSession()
				.createQuery(
						"update CalendarEvent event set event.aprovada = True where event.id = ?")
				.setInteger(0, idEspaco).executeUpdate();

	}

}
