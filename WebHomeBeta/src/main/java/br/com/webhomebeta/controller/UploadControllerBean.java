package br.com.webhomebeta.controller;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.webhomebeta.entity.Usuario;



public class UploadControllerBean {

	private Usuario usuario;
	
	private String fileName;
	
	private CommonsMultipartFile fileData;
	


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	
	
}
