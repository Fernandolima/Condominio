package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.Reserva;


@Repository("reservaDao")
public interface ReservaDAO {
	
	public Reserva save(Reserva reserva);
	public void  delete(Reserva reserva);
	public List<Reserva> getLisReserva();

}
