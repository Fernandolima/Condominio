package br.com.webhomebeta.dao.imp;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.GostouDAO;
import br.com.webhomebeta.entity.Gostou;

public class GostouDAOImp implements GostouDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public Gostou salvar(Gostou gostou){
		factory.getCurrentSession().save(gostou);
		return gostou;
	}

	@Override
	@Transactional
	public void delete(int idUsuario, int idGostou){
		Query q = factory.getCurrentSession().createSQLQuery("DELETE FROM [dbo].[GOSTOU] WHERE ID_USER = ? AND ID_GOSTOU = ?");
		q.setInteger(0, idUsuario);
		q.setInteger(1, idGostou);
	}

	@Override
	@Transactional
	public Gostou get(int id) {
		return (Gostou) factory.getCurrentSession().get(Gostou.class, id );
	}

}
