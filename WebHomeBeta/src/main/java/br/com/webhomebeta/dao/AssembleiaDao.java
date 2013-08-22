package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.Assembleia;

@Repository("assebleiaDao")
public interface AssembleiaDao {
	
	public Assembleia save(Assembleia assembleia);

	public List<Assembleia> getAssembleias();

	public Assembleia editar(int id);

	public void update(Assembleia assembleia);

	public void delete(Assembleia assembleia);

}
