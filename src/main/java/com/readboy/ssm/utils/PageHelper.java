package com.readboy.ssm.utils;

public class PageHelper{	
	
	private long currentPage = 0;	//当前页，默认为0
	private long pageCount;			//总页数
	private boolean hasPre;			//是否有上一页
	private boolean hasNext;		//是否有下一页
	private int pageSize = 10;		//每页记录条数，默认为10
	private long startIndex;		//记录开始索引
	
	public long getCurrentPage() {
		return currentPage;
	}
	public long getPageCount() {
		return pageCount;
	}
	public boolean isHasPre() {
		return hasPre;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public int getPageSize() {
		return pageSize;
	}
	public long getStartIndex() {
		return startIndex;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageCount(long noteCount){
		if(noteCount < this.getPageSize()){
			this.pageCount = 1;
		}else{
			this.pageCount = (noteCount-1) / this.getPageSize()+1;
		}
	}
	public void setHasPre() {
		if(this.getCurrentPage() == 0){
			this.hasPre = false;
		}else{
			this.hasPre = true;
		}
	}
	public void setHasNext() {
		if(this.getCurrentPage() >= this.getPageCount()-1){
			this.hasNext = false;
		}else{
			this.hasNext = true;
		}
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStartIndex() {
		this.startIndex = this.getPageSize()*this.getCurrentPage();
	}
	
	//PageHelper类初始化，注意顺序
	public void pageSetup(long currentPage,long noteCount){
		this.setCurrentPage(currentPage);
		this.setPageCount(noteCount);
		this.setHasPre();
		this.setHasNext();
		this.setStartIndex();
	}
	
	//PageHelper初始化:调整pageSize
	public void pageSetup(long currentPage,long noteCount,int pageSize){
		this.setPageSize(pageSize);
		this.setPageCount(noteCount);
		this.setCurrentPage(currentPage);
		this.setHasPre();
		this.setHasNext();
		this.setStartIndex();
	}
}
