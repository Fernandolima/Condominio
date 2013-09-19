package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[dbo].[NOTIFICACAO]")
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NOTIFICACAO")
	private int idNotificacao;
	
	@Column(name = "TIPO_NOTIFICACAO")
	private String tipoNotificacao;
	
	@Column(name = "ID_NOTIFICADO")
	private int idNotificacado;
	
	@Column(name = "ID_NOTIFICADOR")
	private int idNotificacador;
	
	@Column(name = "IS_VISUALIZADA", columnDefinition = "BOOLEAN")
	private boolean isVisualizada;
	
	@Column(name = "URL")
	private String URL;

	public Notificacao(String tipoNotificacao, int idNotificacado,
			int idNotificacador) {
		this.tipoNotificacao = tipoNotificacao;
		this.idNotificacado = idNotificacado;
		this.idNotificacador = idNotificacador;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getIdNotificacao() {
		return idNotificacao;
	}

	public void setIdNotificacao(int idNotificacao) {
		this.idNotificacao = idNotificacao;
	}

	public boolean isVisualizada() {
		return isVisualizada;
	}

	public void setVisualizada(boolean isVisualizada) {
		this.isVisualizada = isVisualizada;
	}

	public String getTipoNotificacao() {
		return tipoNotificacao;
	}

	public void setTipoNotificacao(String tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}

	public int getIdNotificacado() {
		return idNotificacado;
	}

	public void setIdNotificacado(int idNotificacado) {
		this.idNotificacado = idNotificacado;
	}

	public int getIdNotificacador() {
		return idNotificacador;
	}

	public void setIdNotificacador(int idNotificacador) {
		this.idNotificacador = idNotificacador;
	}

}
