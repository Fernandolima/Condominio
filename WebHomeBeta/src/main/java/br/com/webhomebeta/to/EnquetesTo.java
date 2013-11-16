package br.com.webhomebeta.to;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.webhomebeta.entity.Opcao;
import br.com.webhomebeta.entity.Usuario;

public class EnquetesTo {
	private int idEquete;
	private String equete;
	private Date dataequete;
	private Usuario usuarioEnquete;
	private boolean isAtiva;
	private List<Opcao> opcoes;
	
	
	
	public boolean isAtiva() {
		return isAtiva;
	}
	public void setAtiva(boolean isAtiva) {
		this.isAtiva = isAtiva;
	}
	/**
	 * @return the opcoes
	 */
	public List<Opcao> getOpcoes() {
		return opcoes;
	}
	/**
	 * @param opcoes the opcoes to set
	 */
	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}
	/**
	 * @return the aprovacao

	/**
	
	/**
	 * @return the idEquete
	 */
	public int getIdEquete() {
		return idEquete;
	}
	/**
	 * @return the equete
	 */
	public String getEquete() {
		return equete;
	}
	/**
	 * @return the dataequete
	 */
	public Date getDataequete() {
		return dataequete;
	}
	/**
	 * @return the usuarioEnquete
	 */
	public Usuario getUsuarioEnquete() {
		return usuarioEnquete;
	}
	/**
	 * @param idEquete the idEquete to set
	 */
	public void setIdEquete(int idEquete) {
		this.idEquete = idEquete;
	}
	/**
	 * @param equete the equete to set
	 */
	public void setEquete(String equete) {
		this.equete = equete;
	}
	/**
	 * @param dataequete the dataequete to set
	 */
	public void setDataequete(Date dataequete) {
		this.dataequete = dataequete;
	}
	/**
	 * @param usuarioEnquete the usuarioEnquete to set
	 */
	public void setUsuarioEnquete(Usuario usuarioEnquete) {
		this.usuarioEnquete = usuarioEnquete;
	}
	
}
