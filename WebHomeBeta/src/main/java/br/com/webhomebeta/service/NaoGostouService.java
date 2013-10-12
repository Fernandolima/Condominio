package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.NaoGostouDAO;
import br.com.webhomebeta.entity.NaoGostou;

public class NaoGostouService {
	
	@Autowired
	private NaoGostouDAO naoGostouDAO;

	public NaoGostou salvar(NaoGostou naoGostou){
		return naoGostouDAO.salvar(naoGostou);
	}
	public void delete(NaoGostou naoGostou){
		naoGostouDAO.delete(naoGostou);
	}
	public NaoGostou get(int id){
		return naoGostouDAO.get(id);
	}
	
}
