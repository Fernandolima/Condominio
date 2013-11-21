package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.TentativaLoginDAO;
import br.com.webhomebeta.entity.TentativaLogin;

public class TentativaLoginDAOImp implements TentativaLoginDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public TentativaLogin save(TentativaLogin login) {
		factory.getCurrentSession().save(login);
		return login;
	}

	@Override
	@Transactional
	public void delete(TentativaLogin login) {
		factory.getCurrentSession().delete(login);

	}

	@Override
	@Transactional
	public void update(TentativaLogin login) {
		factory.getCurrentSession().update(login);

	}

	@Override
	@Transactional
	public TentativaLogin get(String nome) {
		return (TentativaLogin) factory.getCurrentSession()
				.createQuery("from TentativaLogin t where t.nome = ?")
				.setString(0, nome).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TentativaLogin> get() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().createQuery("from TentativaLogin").list();
	}

}
