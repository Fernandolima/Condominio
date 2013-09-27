package br.com.webhomebeta.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.webhomebeta.dao.NotificacaoDAO;
import br.com.webhomebeta.entity.Notificacao;

public class NotificacaoDAOImp implements NotificacaoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Notificacao salvar(Notificacao notificacao) {
		sessionFactory.getCurrentSession().save(notificacao);
		return notificacao;
	}

	@Override
	@Transactional
	public void remove(Notificacao notificacao) {

		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Notificacao> getNotificacoes(int id, boolean b) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM [dbo].[NOTIFICACAO] WHERE ID_NOTIFICADO = ? AND IS_VISUALIZADA = ?");
		q.setInteger(0,id);
		q.setBoolean(1, b);
		return (List<Notificacao>)q.list();
	}

}
