package com.myrecommended.services.utils;

public class ImageInfo {
	
	private int width;
	
	private int height;
	
	private String folder;
	
	public ImageInfo(){
	}
	
	public ImageInfo(String folder, int width, int height){
		this.folder = folder;
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int weidth) {
		this.width = weidth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}
}
