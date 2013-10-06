package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.EspacoCondominioDao;
import br.com.webhomebeta.entity.EspacoCondominio;

public class EspacoCondominioDaoImp implements EspacoCondominioDao {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public void save(EspacoCondominio espacoCondominio) {
		factory.getCurrentSession().save(espacoCondominio);

	}

	@Transactional
	public void update(EspacoCondominio condominio) {
		factory.getCurrentSession().update(condominio);

	}

	@Transactional
	public void delete(EspacoCondominio espacoCondominio) {
		factory.getCurrentSession().delete(espacoCondominio);

	}

	@Override
	public List<EspacoCondominio> getLisEspacoCondominios() {
		return factory.getCurrentSession()
				.createCriteria(EspacoCondominio.class).list();
	}

}
