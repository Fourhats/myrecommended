package com.myrecommended.models;

import java.util.List;

public class Page<T> {
	
	private List<T> elements;
	
	private int pageIndex;
	
	private int pageSize;
	
	private Long totalItems;
	
	private int totalPages;

	public Page(List<T> elements, int pageIndex, int pageSize, Long totalItems){
		this.elements = elements;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalItems = totalItems;
		this.setTotalPages(this.calculateTotalPages());
	}
	
	public List<T> getElements() {
		return elements;
	}

	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	private int calculateTotalPages() {
		if(totalItems == 0){
			return 1;
		}
		
		int pages = (int) ((totalItems / pageSize) + 1);
		return (totalItems % pageSize == 0) ? pages - 1 : pages;
	}
}