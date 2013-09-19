package br.com.webhomebeta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webhomebeta.dao.NotificacaoDAO;
import br.com.webhomebeta.entity.Notificacao;

public class NotificacaoService {
	
	@Autowired
	private NotificacaoDAO notificacaoDAO;
	
	public Notificacao salvar(Notificacao notificacao){
		return notificacaoDAO.salvar(notificacao);
	}
	
	public void remove(Notificacao notificacao){
		notificacaoDAO.remove(notificacao);
	}
	
	public List<Notificacao> getNotificacoes(){
		return notificacaoDAO.getPublicacoes();
	}
}
