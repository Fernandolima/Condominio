package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.GostouDAO;
import br.com.webhomebeta.entity.Gostou;

public class GostouDAOImp implements GostouDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public Gostou salvar(Gostou gostou){
		factory.getCurrentSession().save(gostou);
		return gostou;
	}

	@Override
	@Transactional
	public void delete(Gostou gostou){
		factory.getCurrentSession().delete(gostou);
	}

}
