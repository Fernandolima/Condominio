package br.com.webhomebeta.to;

import java.util.Date;

import br.com.webhomebeta.entity.Usuario;

public class AtasTo {

	private int idAtas;
	private String titulo;
	private Date dataCriacao;
	private String atas;
	private String arquivo;
	private Date dataAta;
	private Usuario usuario;
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the idAtas
	 */
	public int getIdAtas() {
		return idAtas;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}
	/**
	 * @return the atas
	 */
	public String getAtas() {
		return atas;
	}
	/**
	 * @return the arquivo
	 */
	public String getArquivo() {
		return arquivo;
	}
	/**
	 * @return the dataAta
	 */
	public Date getDataAta() {
		return dataAta;
	}
	/**
	 * @param idAtas the idAtas to set
	 */
	public void setIdAtas(int idAtas) {
		this.idAtas = idAtas;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	/**
	 * @param atas the atas to set
	 */
	public void setAtas(String atas) {
		this.atas = atas;
	}
	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	/**
	 * @param dataAta the dataAta to set
	 */
	public void setDataAta(Date dataAta) {
		this.dataAta = dataAta;
	}
}