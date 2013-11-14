package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.GastoDAO;
import br.com.webhomebeta.entity.Gasto;

public class GastoService {
	
	@Autowired
	private GastoDAO gastoDAO;
	
	public Gasto save(Gasto gasto){
		return gastoDAO.save(gasto);
	}
	public List<Gasto> get(){
		return gastoDAO.get();
	}
	public void delete(int id){
		gastoDAO.delete(id);
	}
}
