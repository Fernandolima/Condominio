package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.EnqueteDao;
import br.com.webhomebeta.entity.Enquetes;

public class EnqueteDaoImp implements EnqueteDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public Enquetes save(Enquetes enquetes) {
		factory.getCurrentSession().save(enquetes);
		return enquetes;

	}

	@Transactional
	public Enquetes delete(Enquetes enquetes) {
		factory.getCurrentSession().delete(enquetes);
		return enquetes;
	}

	@Transactional
	public Enquetes update(Enquetes enquetes) {
		factory.getCurrentSession().update(enquetes);
		return enquetes;
	}

	@Transactional
	public List<Enquetes> getEnquetes() {
		String sql = "exe[dbo].[ENQUETE]";
		Query q = factory.getCurrentSession().createSQLQuery(
				"SELECT  * FROM [dbo].[ENQUETE]");
		return q.list();
	}
}
