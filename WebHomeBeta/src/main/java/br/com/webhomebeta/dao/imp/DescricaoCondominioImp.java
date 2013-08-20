package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.DescricaoCondominioDAO;
import br.com.webhomebeta.entity.DescricaoCondominio;
import br.com.webhomebeta.entity.Usuario;

public class DescricaoCondominioImp implements DescricaoCondominioDAO{

	@Autowired
	private SessionFactory factory;

	@Transactional
	public DescricaoCondominio save(DescricaoCondominio condominio) {
		String sql = "exec [dbo].[DESCRICAO_CONDOMINIO_I] ?,?,?,?";
		Query q = factory.getCurrentSession().createSQLQuery(sql)
				.addEntity(DescricaoCondominio.class);
		q.setParameter(0, condominio.getIdcondomnio());
		q.setParameter(1, condominio.getBloco());
		q.setParameter(2, condominio.getAp());
		q.setParameter(3, condominio.getNome_condominio());

		return condominio;
		
		
	}

	@Override
	public List<DescricaoCondominio> getDescricaoCondominios() {
		// TODO Auto-generated method stub
		return null;
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

	
}
