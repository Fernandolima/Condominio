package br.com.webhomebeta.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.webhomebeta.entity.Enquetes;

@Repository("EnqueteDao")
public interface EnqueteDao {

	public Enquetes save(Enquetes enquetes);

	public Enquetes delete(Enquetes enquetes);

	public Enquetes update(Enquetes enquetes);
	
	public Enquetes get(int idEnquete);
		
	public List<Enquetes> getListAtiva(boolean ativa);
	
	public List<Enquetes> getEnquetes();
	
	public void update(int quantidadeVotos, int idEnquete);
	

}
