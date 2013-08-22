package br.com.webhomebeta.to;

import java.util.Date;

public class AssembleiaTO {

	private String Assembleia;
	private Date DataAtas;

	/**
	 * @return the assembleia
	 */
	public String getAssembleia() {
		return Assembleia;
	}

	/**
	 * @return the dataAtas
	 */
	public Date getDataAtas() {
		return DataAtas;
	}

	/**
	 * @param assembleia
	 *            the assembleia to set
	 */
	public void setAssembleia(String assembleia) {
		Assembleia = assembleia;
	}

	/**
	 * @param dataAtas
	 *            the dataAtas to set
	 */
	public void setDataAtas(Date dataAtas) {
		DataAtas = dataAtas;
	}
}
