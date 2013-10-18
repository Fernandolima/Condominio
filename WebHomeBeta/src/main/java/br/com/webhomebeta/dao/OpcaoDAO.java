package br.com.webhomebeta.dao;

import java.util.List;

import br.com.webhomebeta.entity.Opcao;

public interface OpcaoDAO {

	public Opcao save(Opcao opcao);

	public Opcao delete(Opcao opcao);

	public Opcao getId(int id);
	

	public void update(int quantidadeVotos, int idEnquete);
	
	
}