package com.reobote.img.domain;

public class Image extends ImageEntity {
	
	private String cpnj;
	private String contractCode;
	private byte[] content; 
	private String name;
	private String extension;
	
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	

	public String getCpnj() {
		return cpnj;
	}
	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
}
