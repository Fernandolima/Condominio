package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.PerfilDAO;
import br.com.webhomebeta.entity.Perfil;

public class PerfilDAOImp implements PerfilDAO {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public Perfil salvar(Perfil perfil) {
		factory.getCurrentSession().save(perfil);
		return perfil;
	}

	@Override
	@Transactional
	public void update(Perfil perfil) {
		factory.getCurrentSession().update(perfil);
	}

	@Override
	@Transactional
	public void remover(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public Perfil get(int idPerfil){
		return (Perfil) factory.getCurrentSession().get(Perfil.class, idPerfil);
	}

}
