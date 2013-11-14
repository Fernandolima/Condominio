package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.entity.Visitante;

public interface VisitanteDao {

	public Visitante save(Visitante visitante);

	public void delete(Visitante visitante);

	public List<Usuario> getLit(String bloco, String ap);

	public List<Visitante> getListVis();
}
