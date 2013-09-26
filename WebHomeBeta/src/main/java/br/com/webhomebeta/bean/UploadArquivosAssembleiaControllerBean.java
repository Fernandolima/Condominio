package br.com.webhomebeta.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.AssembleiaTO;
import br.com.webhomebeta.to.AtasTo;

public class UploadArquivosAssembleiaControllerBean {
	private AssembleiaTO assembleiaTO;
	private boolean assembleia;
	private boolean validDate;
	private String data;
	private boolean titulo;
	private CommonsMultipartFile fileData;
	private Usuario usuario;
	private boolean hasErrorForm = false;

	/**
	 * @return the assembleiaTO
	 */
	public AssembleiaTO getAssembleiaTO() {
		return assembleiaTO;
	}

	/**
	 * @return the assembleia
	 */
	public boolean isAssembleia() {
		return assembleia;
	}

	/**
	 * @return the validDate
	 */
	public boolean isValidDate() {
		return validDate;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the titulo
	 */
	public boolean isTitulo() {
		return titulo;
	}

	/**
	 * @return the fileData
	 */
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
	}

	/**
	 * @param assembleiaTO
	 *            the assembleiaTO to set
	 */
	public void setAssembleiaTO(AssembleiaTO assembleiaTO) {
		this.assembleiaTO = assembleiaTO;
	}

	/**
	 * @param assembleia
	 *            the assembleia to set
	 */
	public void setAssembleia(boolean assembleia) {
		this.assembleia = assembleia;
	}

	/**
	 * @param validDate
	 *            the validDate to set
	 */
	public void setValidDate(boolean validDate) {
		this.validDate = validDate;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}

	/**
	 * @param fileData
	 *            the fileData to set
	 */
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (assembleia == false || validDate == false || titulo == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
