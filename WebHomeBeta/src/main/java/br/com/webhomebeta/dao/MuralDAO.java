package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Mural;

public interface MuralDAO {
		
	public Mural save(Mural mural);
	public void delete(Mural mural);
	public void update(Mural mural);
	public Mural get(int idMural);
	public List<Mural> getList();
}
