package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.TentativaLoginDAO;
import br.com.webhomebeta.entity.TentativaLogin;

public class TentativaLoginService {
	
	@Autowired
	private TentativaLoginDAO loginDAO;
	
	public TentativaLogin save(TentativaLogin login){
		return loginDAO.save(login);
	}
	public void delete(TentativaLogin login){
		loginDAO.delete(login);
	}
	public void update(TentativaLogin login){
		loginDAO.update(login);
	}
	public TentativaLogin get(String login){
		return loginDAO.get(login);
	}
	
	public List<TentativaLogin> get(){
		return loginDAO.get();
	}
	
}
