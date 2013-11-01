package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.OpcaoVotadaDAO;
import br.com.webhomebeta.entity.OpcaoVotada;

public class OpcaoVotadaDAOImp implements OpcaoVotadaDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public OpcaoVotada save(OpcaoVotada opcaoVotada) {
		factory.getCurrentSession().save(opcaoVotada);
		return opcaoVotada;
	}

	@Override
	public void delete(OpcaoVotada opcaoVotada) {
		factory.getCurrentSession().delete(opcaoVotada);
	}

	@Override
	public OpcaoVotada get(int idUser) {
		return (OpcaoVotada) factory.getCurrentSession().get(OpcaoVotada.class, idUser);
	}

}
