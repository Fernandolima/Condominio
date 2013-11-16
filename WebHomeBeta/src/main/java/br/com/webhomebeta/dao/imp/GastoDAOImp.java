package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.GastoDAO;
import br.com.webhomebeta.entity.Gasto;

public class GastoDAOImp implements GastoDAO {

	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public Gasto save(Gasto gasto) {
		factory.getCurrentSession().save(gasto);
		return gasto;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Gasto> get() {
		
		return factory.getCurrentSession().createQuery("from Gasto").list();
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		factory.getCurrentSession().createQuery("delete from Gasto gasto where gasto.idGasto = ?").setInteger(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Gasto> getYears() {
		return factory.getCurrentSession().createQuery("select distinct year(g.data) from Gasto g").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Gasto> getGastos(int year) {
		
		return factory.getCurrentSession().createQuery("from Gasto g where year(g.data) = ?").setInteger(0, year).list();
	}

}
