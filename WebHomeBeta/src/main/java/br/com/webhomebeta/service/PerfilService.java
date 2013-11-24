package br.com.webhomebeta.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.PerfilDAO;
import br.com.webhomebeta.entity.Perfil;

public class PerfilService {
	
	@Autowired
	private PerfilDAO perfilDAO; 
	
	public Perfil salvar(Perfil perfil){
		return perfilDAO.salvar(perfil);
	}
	
	public void update(Perfil perfil){
		perfilDAO.update(perfil);
	}
	
	public Perfil get(int idPerfil){
		return perfilDAO.get(idPerfil);
	}
	
	public Perfil getByUser(int idUser){
		return perfilDAO.getByUser(idUser);
	}
	
	public void update(String img, int idUser){
		perfilDAO.update(img, idUser);
	}
}
