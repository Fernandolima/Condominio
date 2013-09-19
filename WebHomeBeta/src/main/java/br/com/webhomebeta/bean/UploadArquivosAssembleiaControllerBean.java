package br.com.webhomebeta.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.AssembleiaTO;

public class UploadArquivosAssembleiaControllerBean {
	private AssembleiaTO assembleiaTO;
	private boolean assembleia;
	private String data;
	private Usuario usuario;
	private CommonsMultipartFile fileData;
	private boolean hasErrorForm = false;

	/**
	 * @return the assembleia
	 */
	public boolean isAssembleia() {
		return assembleia;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @return the fileData
	 */
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the assembleiaTO
	 */
	public AssembleiaTO getAssembleiaTO() {
		return assembleiaTO;
	}

	/**
	 * @param resultado 
	 * @return the assembleia
	 */
	public boolean isAssembleia(boolean resultado) {
		return assembleia;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
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
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	

	/**
	 * @param hasErrorForm
	 *            the hasErrorForm to set
	 */
	public void setHasErrorForm(boolean hasErrorForm) {
		this.hasErrorForm = hasErrorForm;
	}

	public boolean hasErrors() {
		if (assembleia == false || usuario == null || fileData == null  ) {
			hasErrorForm = true;
			return false;
		}
		hasErrorForm = false;
		return true;
	}

}
