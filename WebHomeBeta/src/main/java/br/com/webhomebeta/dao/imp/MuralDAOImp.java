package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.MuralDAO;
import br.com.webhomebeta.entity.Mural;

public class MuralDAOImp implements MuralDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public Mural save(Mural mural) {
		factory.getCurrentSession().save(mural);
		return mural;
	}

	@Override
	public void delete(Mural mural) {
		factory.getCurrentSession().delete(mural);
	}

	@Override
	public Mural get(int idMural) {
		return (Mural) factory.getCurrentSession().get(Mural.class, idMural);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mural> getList() {
		return factory.getCurrentSession().createCriteria(Mural.class).list();
	}

	@Override
	public void update(Mural mural) {
		factory.getCurrentSession().update(mural);
		
	}

}
