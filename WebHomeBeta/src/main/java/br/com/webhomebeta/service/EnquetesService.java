package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.EnqueteDao;
import br.com.webhomebeta.dao.imp.EnqueteDaoImp;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.EspacoCondominio;

public class EnquetesService {

	@Autowired
	private EnqueteDao dao;

	public void save(Enquetes enquetes) {
		dao.save(enquetes);
	}

	public void delete(Enquetes enquetes) {
		dao.delete(enquetes);
	}

	public void update(Enquetes enquetes) {
		dao.update(enquetes);

	}

	public List<Enquetes> getList() {
		return dao.getEnquetes();

	}
	
	public Enquetes get(int idEnquete){
		return dao.get(idEnquete);
	}
	
	public List<Enquetes> getListAtiva(boolean ativa){
		return dao.getListAtiva(ativa);
	}
	
	public void update(int quantidadeVotos, int idEnquete) {
		dao.update(quantidadeVotos, idEnquete);
	}
}
