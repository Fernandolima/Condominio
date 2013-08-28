package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.DescricaoCondominioDAO;
import br.com.webhomebeta.entity.DescricaoCondominio;

public class DescricaoCondominioImp implements DescricaoCondominioDAO{

	@Autowired
	private SessionFactory factory;

	@Transactional
	public DescricaoCondominio save(DescricaoCondominio condominio) {
//		String sql = "exec [dbo].[DESCRICAO_CONDOMINIO_I] ?,?,?,?";
//		Query q = factory.getCurrentSession().createSQLQuery(sql)
//				.addEntity(DescricaoCondominio.class);
//		q.setParameter(0, condominio.getIdcondomnio());
//		q.setParameter(1, condominio.getBloco());
//		q.setParameter(2, condominio.getNome_condominio());
//		q.setParameter(3, condominio.getQuantAp());
//		q.setParameter(4, condominio.getNumeroInicia());
//
//		q.executeUpdate();
		
		factory.getCurrentSession().save(condominio);
		return condominio;
		
		
	}

	@Transactional
	public List<DescricaoCondominio> getDescricaoCondominios() {
		String sql = "exec [dbo].[SELECT_DESCRICAO_CONDOMINIO]";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class);
		@SuppressWarnings("unchecked")
		List<DescricaoCondominio> descricaoCondominios = q.list();
		return descricaoCondominios;
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
	public DescricaoCondominio getDescricaoById( int idcondomnio){
		String sql = "exe[dbo].[DESCRICAO_CONDOMINIO_ID] ?";
		Query q= factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class).setParameter("0", idcondomnio);
		DescricaoCondominio descricaoCondominio = (DescricaoCondominio) q.uniqueResult();
				return descricaoCondominio;
	}

	@Override
	public DescricaoCondominio editar(int id) {
		String sql = "exe[dbo].[DESCRICAO_CONDOMINIO_ID] ?";
		Query q= factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class).setParameter("0", id);
		DescricaoCondominio descricaoCondominio = (DescricaoCondominio) q.uniqueResult();
				return descricaoCondominio;
	}
	
	@Override
	public void update(DescricaoCondominio descricaoCondominio) {
			factory.getCurrentSession().update(descricaoCondominio);
			
	}
	
	public void  Delete(DescricaoCondominio descricaoCondominio) {
		factory.getCurrentSession().delete(descricaoCondominio);
	}

	@Override
	public void delete(DescricaoCondominio descricacoCondominio) {
		// TODO Auto-generated method stub
		
	}


	
}