package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.EnqueteDao;
import br.com.webhomebeta.entity.AtasEntity;
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Enquetes> getEnquetes() {
		return factory.getCurrentSession().createCriteria(Enquetes.class)
				.list();
	}

	@Override
	public Enquetes get(int idEnquete) {
		return (Enquetes) factory.getCurrentSession().get(Enquetes.class,
				idEnquete);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Enquetes> getListAtiva(boolean ativa) {
		return factory.getCurrentSession()
				.createQuery("from Enquetes e where e.isAtiva = ?")
				.setBoolean(0, ativa).list();
	}

	@Transactional
	public void update(int quantidadeVotos, int idEnquete) {
		Enquetes enquetes = (Enquetes) factory
				.getCurrentSession()
				.createQuery(
						"select new Enquetes(e.totalVotos) from Enquetes e where e.idEquete = ?")
				.setInteger(0, idEnquete);

		factory.getCurrentSession()
				.createQuery(
						"update Enquetes e set e.totalVotos = ? where e.idEquete = ?")
				.setInteger(0, quantidadeVotos + enquetes.getTotalVotos())
				.setInteger(1, idEnquete).executeUpdate();
	}
}
