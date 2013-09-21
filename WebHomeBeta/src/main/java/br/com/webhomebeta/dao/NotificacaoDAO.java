package br.com.webhomebeta.dao;


import java.util.List;

import br.com.webhomebeta.entity.Notificacao;

public interface NotificacaoDAO {
	
	public Notificacao salvar(Notificacao notificacao);
	public void remove (Notificacao notificacao);
	public List<Notificacao> getNotificacoes(int id, boolean b);
}
