package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.AssembleiaDao;
import br.com.webhomebeta.entity.Assembleia;
import br.com.webhomebeta.entity.AtasEntity;

public class AssembleiaImp implements  AssembleiaDao {

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public Assembleia Inseri(Assembleia assembleia) {
		factory.getCurrentSession().save(assembleia);
		return assembleia;
		
		
	}

	@Transactional
	public Assembleia save(Assembleia assembleia) {
		factory.getCurrentSession().save(assembleia);
		return assembleia;
	}

	public Assembleia editar(int id) {
		String sql = "exe[dbo].[ASSEMBLEIA] ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Assembleia.class).setParameter(0, id);
		Assembleia assembleia = (Assembleia) q.uniqueResult();
		return assembleia;
	}

	public void update(Assembleia assembleia) {
		factory.getCurrentSession().update(assembleia);

	}

	public void delete(Assembleia assembleia) {
		factory.getCurrentSession().delete(assembleia);

	}

	@Transactional
	public List<Assembleia> getAssembleias() {
		String sql = "exe[dbo].[ASSEMBLEIA]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class);
		@SuppressWarnings("unchecked")
		List<Assembleia> assembleia = q.list();
		return assembleia;
	}


}
