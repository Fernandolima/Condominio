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
		String sql = "exec [dbo].[ASSEMBLEIA_CONDOMINIO_I] ?,?,?,?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(Assembleia.class);
		q.setParameter(0, assembleia.getIdAssembleia());
		q.setParameter(1, assembleia.getUsuarioAssebleia());
		q.setParameter(2, assembleia.getComentario());
		q.setParameter(3, assembleia.getDataCriacao()); 

		q.executeUpdate();
		return assembleia;
		
		
	}

	@Transactional
	public List<Assembleia> getAssembleia() {
		String sql = "exe[dbo].[ASSEMBLEIA]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(AtasEntity.class);
		@SuppressWarnings("unchecked")
		List<Assembleia> assembleia = q.list();
		return assembleia;

	}

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

	@Override
	public List<Assembleia> getAssembleias() {
		// TODO Auto-generated method stub
		return null;
	}

}
