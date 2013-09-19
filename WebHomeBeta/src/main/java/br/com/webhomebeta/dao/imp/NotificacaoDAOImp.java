package br.com.webhomebeta.dao.imp;

import java.util.List;

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

	@Override
	@Transactional
	public List<Notificacao> getPublicacoes() {
	
		return null;
	}

}
