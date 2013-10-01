package br.com.webhomebeta.service;

import br.com.webhomebeta.dao.PerfilDAO;
import br.com.webhomebeta.entity.Perfil;

public class PerfilService {
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
}
