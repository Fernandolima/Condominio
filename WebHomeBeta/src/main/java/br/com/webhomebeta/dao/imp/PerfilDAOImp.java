package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.PerfilDAO;
import br.com.webhomebeta.entity.Perfil;

public class PerfilDAOImp implements PerfilDAO {
	
	@Autowired
	private SessionFactory factory;
	@Override
	public Perfil salvar(Perfil perfil) {
		factory.getCurrentSession().save(perfil);
		return perfil;
	}

	@Override
	public void update(Perfil perfil) {
		factory.getCurrentSession().update(perfil);
	}

	@Override
	public void remover(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}

}
