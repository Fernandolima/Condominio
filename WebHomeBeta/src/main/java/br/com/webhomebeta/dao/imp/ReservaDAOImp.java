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
	@Transactional
	public void delete(Reserva reserva) {
		factory.getCurrentSession().delete(reserva);

	}

	@Override
	@Transactional
	public List<Reserva> getLisReserva() {
		return factory.getCurrentSession().createQuery("from Reserva").list();

	}

	@Override
	@Transactional
	public Reserva get(int idReserva) {
		return (Reserva) factory.getCurrentSession().get(Reserva.class,
				idReserva);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Reserva> getHistorico(int idUser) {
		return factory.getCurrentSession()
				.createQuery("from Reserva r where r.idUser = ?")
				.setInteger(0, idUser).list();
	}

	@Override
	@Transactional
	public void update(int idReserva, boolean ativa) {
		factory.getCurrentSession()
				.createQuery(
						"update Reserva r set r.ativa = ? where r.idReserva = ?")
				.setBoolean(0, ativa).setInteger(1, idReserva).executeUpdate();

	}

}
