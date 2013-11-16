package br.com.webhomebeta.json;

public class JsonBlocos {
	private String bloco;
	private int idBloco;
	private int quatApAndares; //Quat de apartamento no andar
	private String numeroInicial;
	private String quantAp;
	private int erro;
	
	
	
	public JsonBlocos(int erro) {
		super();
		this.erro = erro;
	}




	public JsonBlocos(String bloco, int idBloco, int quatApAndares,
			String numeroInicial, String quantAp) {
		super();
		this.bloco = bloco;
		this.idBloco = idBloco;
		this.quatApAndares = quatApAndares;
		this.numeroInicial = numeroInicial;
		this.quantAp = quantAp;
	}


	
	
	public int getErro() {
		return erro;
	}




	public void setErro(int erro) {
		this.erro = erro;
	}




	/**
	 * @return the bloco
	 */
	public String getBloco() {
		return bloco;
	}


	/**
	 * @return the idBloco
	 */
	public int getIdBloco() {
		return idBloco;
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
	 * @param idBloco the idBloco to set
	 */
	public void setIdBloco(int idBloco) {
		this.idBloco = idBloco;
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
