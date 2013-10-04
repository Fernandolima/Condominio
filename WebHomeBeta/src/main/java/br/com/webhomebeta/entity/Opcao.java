package br.com.webhomebeta.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name = "[dbo].[OPCAO]")
public class Opcao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPCAO")
	private int idOpcao;

	@Column(name = "OPCAO")
	private String opcao;

	
	@Column(name = "QUAT_VOTOS")
	private int quatVots;
	
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ENQUETE", nullable = false)
	private Enquetes enquetes;
	
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "opcao", orphanRemoval = true)
	private Set<OpcaoVotada> opcaoVotadas = new  HashSet<>(0);

	public Opcao(){
		
	}
	
	public Opcao(String opcao, Enquetes enquetes){
		this.opcao = opcao;
		this.enquetes = enquetes;
	}


	
	public Enquetes getEnquetes() {
		return enquetes;
	}

	public void setEnquetes(Enquetes enquetes) {
		this.enquetes = enquetes;
	}

	/**
	 * @return the idOpcao
	 */
	public int getIdOpcao() {
		return idOpcao;
	}
	
	/**
	 * @return the opcao
	 */
	public String getOpcao() {
		return opcao;
	}

	/**
	 * @return the quatVots
	 */
	public int getQuatVots() {
		return quatVots;
	}

	/**
	 * @param idOpcao the idOpcao to set
	 */
	public void setIdOpcao(int idOpcao) {
		this.idOpcao = idOpcao;
	}

	/**
	 * @param opcao the opcao to set
	 */
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	
	/**
	 * @param quatVots the quatVots to set
	 */
	public void setQuatVots(int quatVots) {
		this.quatVots = quatVots;
	}
}
