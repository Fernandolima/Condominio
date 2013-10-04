package br.com.webhomebeta.dao;

import br.com.webhomebeta.entity.OpcaoVotada;

public interface OpcaoVotadaDAO {
		
	public OpcaoVotada save(OpcaoVotada opcaoVotada);
	public void delete(OpcaoVotada opcaoVotada);
	public OpcaoVotada get(int idUser);
	
}
