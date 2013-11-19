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
		return (Perfil) factory.getCurrentSession().createQuery("from Perfil p where p.idPerfil = ?").setInteger(0, idPerfil).uniqueResult();
	}

	@Override
	@Transactional
	public Perfil getByUser(int idUser) {
		
		return (Perfil) factory.getCurrentSession().createQuery("from Perfil p where p.idUser = ?").setInteger(0, idUser).uniqueResult();
	}

	@Override
	@Transactional
	public void update(String img) {
		factory.getCurrentSession().createQuery("update Perfil p set p.imagemUsuario = ?").setString(0, img).executeUpdate();
		
	}

}
