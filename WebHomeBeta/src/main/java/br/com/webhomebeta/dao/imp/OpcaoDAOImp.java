package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.OpcaoDAO;
import br.com.webhomebeta.entity.Opcao;

public class OpcaoDAOImp implements OpcaoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Opcao save(Opcao opcao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Opcao delete(Opcao opcao) {
		// TODO Auto-generated method stub
		return null;
	}

}
