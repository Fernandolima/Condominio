package br.com.webhomebeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "[dbo].[OPCAO_VOTADA]")
public class OpcaoVotada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPCAO_VOTADA")
	private int idOpcaoVotada;

	@Column(name = "ID_USER")
	private int idUser;

	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_OPCAO", nullable = false)
	@JsonIgnoreProperties(value = "opcao")
	private Opcao opcao;

	public OpcaoVotada() {

	}

	public OpcaoVotada(Opcao opcao, int idUser) {
		this.opcao = opcao;
		this.idUser = idUser;
	}

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
