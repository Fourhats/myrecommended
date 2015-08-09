package com.myrecommended.models;

import java.io.Serializable;

public class UploadedFile implements Serializable{
	
	private static final long serialVersionUID = -4551500069241817500L;
	private String name;
	
	public UploadedFile(){
		super();
	}
	
	public UploadedFile(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}