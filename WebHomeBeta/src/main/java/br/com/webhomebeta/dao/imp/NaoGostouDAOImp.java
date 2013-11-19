package br.com.webhomebeta.dao.imp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.NaoGostouDAO;
import br.com.webhomebeta.entity.NaoGostou;

public class NaoGostouDAOImp implements NaoGostouDAO {

	@Autowired
	private SessionFactory factory;
	@Override
	@Transactional
	public NaoGostou salvar(NaoGostou naoGostou) {
		factory.getCurrentSession().save(naoGostou);
		return naoGostou;
	}

	@Override
	@Transactional
	public void delete(NaoGostou naoGostou) {
		factory.getCurrentSession().delete(naoGostou);
	}

	@Override
	@Transactional
	public NaoGostou get(int id) {
		return (NaoGostou) factory.getCurrentSession().get(NaoGostou.class, id);
	}

}
