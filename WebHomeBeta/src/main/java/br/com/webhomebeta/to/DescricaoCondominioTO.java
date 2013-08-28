package br.com.webhomebeta.to;

public class DescricaoCondominioTO {
	
	private String bloco;
	private String idbloco;
	private int idcondomnio;
	private int quatApAndares; //Quat de apartamento no andar
	private String numeroInicial;
	private String quantAp;
	/**
	 * @return the blocoper
	 */
	public String getBloco() {
		return bloco;
	}
	/**
	 * @return the idcondomnio
	 */
	public int getIdcondomnio() {
		return idcondomnio;
	}
	
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	/**
	 * @param idcondomnio the idcondomnio to set
	 */
	public void setIdcondomnio(int idcondomnio) {
		this.idcondomnio = idcondomnio;
	}
	/**
	 * @return the quatApAndares
	 */
	public int getQuatApAndares() {
		return quatApAndares;
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
	/**
	 * @param quatApAndares the quatApAndares to set
	 */
	public void setQuatApAndares(String quatApAndares) {
		quatApAndares = quatApAndares;
	}
	/**
	 * @param numeroInicia the numeroInicia to set
	 */
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
	/**
	 * @return the idbloco
	 */
	public String getIdbloco() {
		return idbloco;
	}
	/**
	 * @param idbloco the idbloco to set
	 */
	public void setIdbloco(String idbloco) {
		this.idbloco = idbloco;
	}

}