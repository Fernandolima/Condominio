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
	private String senha;
	private String novaSenha;
	private String confNovaSenha;
	


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfNovaSenha() {
		return confNovaSenha;
	}

	public void setConfNovaSenha(String confNovaSenha) {
		this.confNovaSenha = confNovaSenha;
	}


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
