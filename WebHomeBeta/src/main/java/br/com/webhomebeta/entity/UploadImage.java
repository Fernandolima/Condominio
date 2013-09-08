package br.com.webhomebeta.entity;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadImage {
	private String fileName;
	private CommonsMultipartFile fileData;
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
