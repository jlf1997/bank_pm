package com.readboy.ssm.utils;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageModel {
	
	
	public PageModel() {
		
	}

	public PageModel(Page page) {
		this.content = page.getContent();
		this.totalPages = page.getTotalPages();
		this.totalSize = page.getTotalElements();
	
	}
	private List content;
	
	private Integer totalPages;
	
	private Long totalSize;

	public List getContent() {
		return content;
	}

	public void setContent(List content) {
		this.content = content;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}


	
	
	
	
}
