package br.com.webhomebeta.dao.imp;

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
	public void salvarComentario(Comentario comentario) {
		
		factory.getCurrentSession().save(comentario);
		
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

}
