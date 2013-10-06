package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.ReservaDAO;
import br.com.webhomebeta.entity.Reserva;

public class ReservaDAOImp implements ReservaDAO {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public Reserva save(Reserva reserva) {
		factory.getCurrentSession().save(reserva);
		return reserva;
	}

	@Override
	public void delete(Reserva reserva) {
		factory.getCurrentSession().delete(reserva);

	}

	@Override
	public List<Reserva> getLisReserva() {
		return factory.getCurrentSession().createCriteria(Reserva.class).list();

	}

}
