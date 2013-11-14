package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Gasto;

public interface GastoDAO {
	
	public Gasto save(Gasto gasto);
	public List<Gasto> get();
	public void delete(int id);
	
}
