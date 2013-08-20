package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.PublicacaoDAO;
import br.com.webhomebeta.entity.Publicacao;

public class PublicacaoDAOImp implements PublicacaoDAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public void salvarPublicacao(Publicacao publicacao) {
		
		factory.getCurrentSession().save(publicacao);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Publicacao> getPublicacoes() {
		
		String sql = "exec [dbo].[SELECT_PUBLICACOES]";
		Query q = factory.getCurrentSession().createSQLQuery(sql);
		
		return q.list();
		
	}

}
