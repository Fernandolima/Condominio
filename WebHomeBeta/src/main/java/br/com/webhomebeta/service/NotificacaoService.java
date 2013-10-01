package br.com.webhomebeta.service;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

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
	
	public List<Notificacao> getNotificacoes(int id, boolean b){
		return notificacaoDAO.getNotificacoes(id, b);
	}
	
	public void update(int idNotificacao, boolean b){
		notificacaoDAO.update(idNotificacao, b);
	}
}

