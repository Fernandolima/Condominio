package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webhomebeta.dao.GostouDAO;
import br.com.webhomebeta.entity.Gostou;

@Service
public class GostouService {
	
	@Autowired
	private GostouDAO gostouDAO;
	
	public Gostou salvar(Gostou gostou){
		return gostouDAO.salvar(gostou);
	}
	
	public void delete(int idUsuario, int idGostou){
		gostouDAO.delete(idUsuario, idGostou);
	}
	
	public Gostou get ( int id){
		return gostouDAO.get(id);
	}
}
