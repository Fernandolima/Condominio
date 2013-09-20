package br.com.webhomebeta.dao.imp;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.ComentarioDAO;
import br.com.webhomebeta.entity.Comentario;
import br.com.webhomebeta.entity.Publicacao;

public class ComentarioDAOImp implements ComentarioDAO{
	
	
	@Autowired
	private SessionFactory factory;
	@Override
	@Transactional
	public Comentario salvarComentario(Comentario comentario) {
		
		factory.getCurrentSession().save(comentario);
		
		return comentario;
		
	}

	@Override
	public Comentario getComentarios(Publicacao publicacao) {
		
		return null;
	}

	@Override
	public Comentario getComentarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void update(int id, String imagem) {
		Query q = factory.getCurrentSession().createSQLQuery("UPDATE [dbo].[COMENTARIO_PUBLICACAO] SET IMAGEM = ? WHERE ID_USER = ?");
		q.setParameter(0, imagem);
		q.setParameter(1,id);
		q.executeUpdate();
	}

}
