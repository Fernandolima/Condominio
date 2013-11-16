package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.EspacoCondominioDao;
import br.com.webhomebeta.entity.Enquetes;
import br.com.webhomebeta.entity.EspacoCondominio;

public class EspacoCondominioDaoImp implements EspacoCondominioDao {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public EspacoCondominio save(EspacoCondominio espacoCondominio) {
		factory.getCurrentSession().save(espacoCondominio);
		return espacoCondominio;

	}

	@Transactional
	public void update(EspacoCondominio condominio) {
		factory.getCurrentSession().update(condominio);

	}

	@Transactional
	public void delete(EspacoCondominio espacoCondominio) {
		factory.getCurrentSession().delete(espacoCondominio);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<EspacoCondominio> getLisEspacoCondominios() {
		return factory.getCurrentSession().createQuery("from EspacoCondominio e order by e.espaco").list();
	}

	@Transactional
	public void saveEspaco(EspacoCondominio espacoCondominio) {
		factory.getCurrentSession().save(espacoCondominio);
		
	}

	@Override
	@Transactional
	public EspacoCondominio get(int idEspaco) {
		return (EspacoCondominio) factory.getCurrentSession().get(EspacoCondominio.class, idEspaco);
	}
	
}
