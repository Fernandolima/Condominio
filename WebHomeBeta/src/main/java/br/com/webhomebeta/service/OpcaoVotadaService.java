package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.OpcaoVotadaDAO;
import br.com.webhomebeta.entity.OpcaoVotada;

public class OpcaoVotadaService {

	@Autowired
	public OpcaoVotadaDAO opcaoVotadaDAO;
	
	public OpcaoVotada save(OpcaoVotada opcaoVotada){
		return opcaoVotadaDAO.save(opcaoVotada);
	}
	
	public OpcaoVotada get(int idUser){
		return opcaoVotadaDAO.get(idUser);
	}
}
