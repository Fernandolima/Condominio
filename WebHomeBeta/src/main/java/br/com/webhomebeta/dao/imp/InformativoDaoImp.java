package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.InformativoDao;
import br.com.webhomebeta.entity.Informativo;

public class InformativoDaoImp implements InformativoDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public Informativo save(Informativo informativo) {
		factory.getCurrentSession().save(informativo);
		return informativo;
	}

	@Transactional
	public List<Informativo> getListInformativos() {
		Query q = factory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT * FROM INFORMATIVO ORDER BY DATA_PUBLICACAO DESC")
				.addEntity(Informativo.class);
		@SuppressWarnings("unchecked")
		List<Informativo> informativos = q.list();
		return informativos;
	}

	@Transactional
	public void delete(Informativo informativo) {
		factory.getCurrentSession().delete(informativo);

	}

}
