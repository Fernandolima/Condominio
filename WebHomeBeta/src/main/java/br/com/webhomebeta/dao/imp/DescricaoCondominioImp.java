package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.DescricaoCondominioDAO;
import br.com.webhomebeta.entity.DescricaoCondominio;

public class DescricaoCondominioImp implements DescricaoCondominioDAO {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public DescricaoCondominio save(DescricaoCondominio condominio) {
		// String sql = "exec [dbo].[DESCRICAO_CONDOMINIO_I] ?,?,?,?";
		// Query q = factory.getCurrentSession().createSQLQuery(sql)
		// .addEntity(DescricaoCondominio.class);
		// q.setParameter(0, condominio.getIdcondomnio());
		// q.setParameter(1, condominio.getBloco());
		// q.setParameter(2, condominio.getNome_condominio());
		// q.setParameter(3, condominio.getQuantAp());
		// q.setParameter(4, condominio.getNumeroInicia());
		//
		// q.executeUpdate();

		factory.getCurrentSession().save(condominio);
		return condominio;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DescricaoCondominio> getDescricaoCondominios() {
		return factory.getCurrentSession().createSQLQuery("SELECT * FROM [dbo].[DESCRICAO_CONDOMINIO]").addEntity(DescricaoCondominio.class).list();
	}

	@Transactional
	public List<DescricaoCondominio> getDescricaoCondominio() {
		String sql = "exec [dbo].[DESCRICAO_CONDOMINIO_I]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class);
		@SuppressWarnings("unchecked")
		List<DescricaoCondominio> descricaoCondominios = q.list();
		return descricaoCondominios;
	}

	@Transactional
	public DescricaoCondominio getDescricaoById(int idcondomnio) {
		String sql = "exe[dbo].[DESCRICAO_CONDOMINIO_ID] ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class)
				.setParameter("0", idcondomnio);
		DescricaoCondominio descricaoCondominio = (DescricaoCondominio) q
				.uniqueResult();
		return descricaoCondominio;
	}

	@Transactional
	public DescricaoCondominio editar(int id) {
		String sql = "exe[dbo].[DESCRICAO_CONDOMINIO_ID] ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class).setParameter("0", id);
		DescricaoCondominio descricaoCondominio = (DescricaoCondominio) q
				.uniqueResult();
		return descricaoCondominio;
	}

	@Transactional
	public void update(DescricaoCondominio descricaoCondominio) {
		factory.getCurrentSession().update(descricaoCondominio);

	}

	@Transactional
	public void delete(DescricaoCondominio descricaoCondominio) {
		factory.getCurrentSession().delete(descricaoCondominio);
	}

	@Override
	@Transactional
	public DescricaoCondominio get(int id) {
	
		return (DescricaoCondominio) factory.getCurrentSession().createSQLQuery("SELECT * FROM [dbo].[DESCRICAO_CONDOMINIO] WHERE ID_BLOCO = ?").addEntity(DescricaoCondominio.class).setInteger(0, id).uniqueResult();
	
	}

}