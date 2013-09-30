package br.com.webhomebeta.dao;


import br.com.webhomebeta.entity.Gostou;

public interface GostouDAO {
	
	public Gostou salvar(Gostou gostou);
	public void delete(int idUsuario, int idGostou);
	public Gostou get(int id);
	
}
