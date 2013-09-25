package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;

import br.com.webhomebeta.dao.PublicacaoDAO;
import br.com.webhomebeta.entity.Publicacao;

public class PublicacaoDAOImp implements PublicacaoDAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public Publicacao salvarPublicacao(Publicacao publicacao) {
		
		factory.getCurrentSession().save(publicacao);
		return publicacao;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Publicacao> getPublicacoes() {
		
		String sql = "exec [dbo].[SELECT_PUBLICACOES]";
		Query q = factory.getCurrentSession().createSQLQuery(sql).addEntity(Publicacao.class).setCacheable(true);
		
		return q.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Publicacao> getPublicacao(int idUser){
		String sql = "SELECT * FROM [dbo].[PUBLICACAO] WHERE ID_USER = ?";
		Query q = factory.getCurrentSession().createSQLQuery(sql).addEntity(Publicacao.class).setParameter(0,idUser);
		return (List<Publicacao>) q.list();
				
	}
	
	
	@Override
	@Transactional
	public void update(int id, String imagem) {
		Query q = factory.getCurrentSession().createSQLQuery("UPDATE [dbo].[PUBLICACAO] SET IMAGEM = ? WHERE ID_USER = ?");
		q.setParameter(0, imagem);
		q.setParameter(1, id);
		q.executeUpdate();
	}

	@Transactional
	public void deletarPublicacao(int idUsuario, int idPublicacao) {
		Query q = factory.getCurrentSession().createSQLQuery("DELETE FROM [dbo].[PUBLICACAO]  WHERE ID_USER = ? AND ID_PUBLICACAO = ?");
		q.setParameter(0, idUsuario);
		q.setParameter(1, idPublicacao);
		q.executeUpdate();
	}
	@Override
	@Transactional
	public Publicacao getUnicaPublicacao(int idPublicacao) {
		Publicacao p = (Publicacao) factory.getCurrentSession().get(Publicacao.class,idPublicacao);
		return p;
	}
	
}
