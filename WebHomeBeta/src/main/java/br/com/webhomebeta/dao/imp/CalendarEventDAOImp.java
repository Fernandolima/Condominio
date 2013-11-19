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
		return factory.getCurrentSession().createQuery("from CalendarEvent event where event.idEspaco = ? and event.aprovada = True").setInteger(0, id).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CalendarEvent> get() {
		return factory.getCurrentSession().createQuery("from CalendarEvent event where event.aprovada = False")
				.list();
	}

	@Override
	@Transactional
	public void delete(int id) {
		factory.getCurrentSession().createQuery("delete from CalendarEvent event where event.id = ?").setInteger(0, id).executeUpdate();
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
	public void update(int idEspaco, boolean ativa) {
		factory.getCurrentSession()
				.createQuery(
						"update CalendarEvent event set event.aprovada = ? where event.id = ?").setBoolean(0, ativa)
				.setInteger(1, idEspaco).executeUpdate();

	}

	@Override
	@Transactional
	public List<CalendarEvent> getAll() {
		return factory.getCurrentSession().createQuery("from CalendarEvent").list();
	}

	@Override
	@Transactional
	public List<CalendarEvent> getHistorico(int idUser) {
		return factory.getCurrentSession().createQuery("from CalendarEvent event where event.idUser = ? ").setInteger(0, idUser).list();
	}

	@Override
	@Transactional
	public CalendarEvent getEvent(int id) {
		return (CalendarEvent) factory.getCurrentSession().createQuery("from CalendarEvent event where event.id = ?").setInteger(0, id).uniqueResult();
	}

}
