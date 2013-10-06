package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.ReservaDAO;
import br.com.webhomebeta.entity.Reserva;

@Service("reservaService")
public class ReservaService {

	@Autowired
	private ReservaDAO reservaDao;

	public void save(Reserva reserva) {
		reservaDao.save(reserva);
	}

	public void delete(Reserva reserva) {
		reservaDao.delete(reserva);
	}

	public List<Reserva> getLisReservas() {
		return reservaDao.getLisReserva();

	}

}
