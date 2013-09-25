package br.com.webhomebeta.bean;

import java.util.LinkedList;

import br.com.webhomebeta.entity.FileData;
import br.com.webhomebeta.entity.Usuario;
import br.com.webhomebeta.to.PerfilTO;

public class PerfilControllerBean {
	
	private PerfilTO perfilTO;
	private Usuario usuario;
	private LinkedList<FileData> files = new LinkedList<>();
	private FileData fileData;
	
	
	public LinkedList<FileData> getFiles() {
		return files;
	}
	public void setFiles(LinkedList<FileData> files) {
		this.files = files;
	}
	public FileData getFileData() {
		return fileData;
	}
	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}
	public PerfilTO getPerfilTO() {
		return perfilTO;
	}
	public void setPerfilTO(PerfilTO perfilTO) {
		this.perfilTO = perfilTO;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
