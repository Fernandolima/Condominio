package br.com.webhomebeta.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.AtasTo;

public class UploadArquivosAtasControllerBean {
	private AtasTo atasTo;
	private boolean atas;
	private String data;
	private boolean dataVal;
	private boolean titulo;
    boolean hasErrorForm = false;
	private CommonsMultipartFile fileData;
	private Usuario usuario;


	/**
	 * @return the atasTo
	 */
	public AtasTo getAtasTo() {
		return atasTo;
	}

	/**
	 * @return the atas
	 */
	public boolean isAtas() {
		return atas;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the dataVal
	 */
	public boolean isDataVal() {
		return dataVal;
	}

	/**
	 * @return the titulo
	 */
	public boolean isTitulo() {
		return titulo;
	}

	/**
	 * @return the hasErrorForm
	 */
	public boolean isHasErrorForm() {
		return hasErrorForm;
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
	 * @param atasTo
	 *            the atasTo to set
	 */
	public void setAtasTo(AtasTo atasTo) {
		this.atasTo = atasTo;
	}

	/**
	 * @param atas
	 *            the atas to set
	 */
	public void setAtas(boolean atas) {
		this.atas = atas;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param dataVal
	 *            the dataVal to set
	 */
	public void setDataVal(boolean dataVal) {
		this.dataVal = dataVal;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(boolean titulo) {
		this.titulo = titulo;
	}


	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
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

	public boolean hasErrors() {
		if (atas == false || dataVal == false
				|| titulo == false) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
