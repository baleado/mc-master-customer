package com.jpaa.mastercard.mc.services.model;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> data;

	private Integer totalPages;

	private Long totalElements;

	private Integer pageNumber;

	private Integer pageSize;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [data=" + data + ", totalPages=" + totalPages + ", totalElements=" + totalElements
				+ ", pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}

}
