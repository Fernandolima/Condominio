package br.com.webhomebeta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TENTATIVA_LOGIN")
public class TentativaLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TENTATIVA")
	private int id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "TENTATIVAS")
	private int tentativas;
	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTentativas() {
		return tentativas;
	}
	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
