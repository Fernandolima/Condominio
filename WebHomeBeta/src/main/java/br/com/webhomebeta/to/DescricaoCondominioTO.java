package br.com.webhomebeta.to;

public class DescricaoCondominioTO {
	
	private String bloco;
	private int idBloco;
	private String quatApAndares; //Quat de apartamento no andar
	private String numeroInicial;
	private String quantAp;
	/**
	 * @return the blocoper
	 */
	public String getBloco() {
		return bloco;
	}
	
	
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
	public int getIdBloco() {
		return idBloco;
	}


	public void setIdBloco(int idBloco) {
		this.idBloco = idBloco;
	}


	
	public String getQuatApAndares() {
		return quatApAndares;
	}


	public void setQuatApAndares(String quatApAndares) {
		this.quatApAndares = quatApAndares;
	}


	/**
	 * @return the numeroInicia
	 */
	public String getNumeroInicia() {
		return numeroInicial;
	}
	/**
	 * @return the quantAp
	 */
	public String getQuantAp() {
		return quantAp;
	}
	
	public void setNumeroInicia(String numeroInicial) {
		this.numeroInicial = numeroInicial;
	}
	/**
	 * @param quantAp the quantAp to set
	 */
	public void setQuantAp(String quantAp) {
		this.quantAp = quantAp; 
	}
	/**
	 * @return the numeroInicial
	 */
	public String getNumeroInicial() {
		return numeroInicial;
	}
	/**
	 * @param numeroInicial the numeroInicial to set
	 */
	public void setNumeroInicial(String numeroInicial) {
		this.numeroInicial = numeroInicial;
	}


}