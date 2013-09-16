package br.com.webhomebeta.json;

public class JsonBlocos {
	private String bloco;
	private int idcondomnio;
	private int quatApAndares; //Quat de apartamento no andar
	private String numeroInicial;
	private String quantAp;
	
	
	public JsonBlocos(String bloco, int idcondomnio, int quatApAndares,
			String numeroInicial, String quantAp) {
		super();
		this.bloco = bloco;
		this.idcondomnio = idcondomnio;
		this.quatApAndares = quatApAndares;
		this.numeroInicial = numeroInicial;
		this.quantAp = quantAp;
	}


	/**
	 * @return the bloco
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


	/**
	 * @return the quatApAndares
	 */
	public int getQuatApAndares() {
		return quatApAndares;
	}


	/**
	 * @return the numeroInicial
	 */
	public String getNumeroInicial() {
		return numeroInicial;
	}


	/**
	 * @return the quantAp
	 */
	public String getQuantAp() {
		return quantAp;
	}


	/**
	 * @param bloco the bloco to set
	 */
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
	 * @param quatApAndares the quatApAndares to set
	 */
	public void setQuatApAndares(int quatApAndares) {
		this.quatApAndares = quatApAndares;
	}


	/**
	 * @param numeroInicial the numeroInicial to set
	 */
	public void setNumeroInicial(String numeroInicial) {
		this.numeroInicial = numeroInicial;
	}


	/**
	 * @param quantAp the quantAp to set
	 */
	public void setQuantAp(String quantAp) {
		this.quantAp = quantAp;
	}
	
	
	
	
	
	

}
