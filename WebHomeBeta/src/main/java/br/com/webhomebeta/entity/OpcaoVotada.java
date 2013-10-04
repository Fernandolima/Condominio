package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "[dbo].[OPCAO_VOTADA]")
public class OpcaoVotada {
		
	@Column(name = "ID_USER")
	private int idUser;
	
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_OPCAO", nullable = false)
	private Opcao opcao;
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Opcao getOpcao() {
		return opcao;
	}
	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}
	
	
	
	
}
