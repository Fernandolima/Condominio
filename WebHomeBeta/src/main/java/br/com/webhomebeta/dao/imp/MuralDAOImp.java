package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.MuralDAO;
import br.com.webhomebeta.entity.AtasEntity;
import br.com.webhomebeta.entity.Mural;

public class MuralDAOImp implements MuralDAO{
	
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public Mural save(Mural mural) {
		factory.getCurrentSession().save(mural);
		return mural;
	}

	@Transactional
	@Override
	public void delete(Mural mural) {
		factory.getCurrentSession().delete(mural);
	}

	@Transactional
	@Override
	public Mural get(int idMural) {
		return (Mural) factory.getCurrentSession().get(Mural.class, idMural);
		
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Mural> getList() {
		Query q = factory.getCurrentSession().createSQLQuery("SELECT * FROM MURAL ORDER BY DATA DESC").addEntity(Mural.class);
		@SuppressWarnings("unchecked")
		List<Mural> mural = q.list();
		return mural;
		
		
			}

	@Transactional
	@Override
	public void update(Mural mural) {
		factory.getCurrentSession().update(mural);
		
	}

}
