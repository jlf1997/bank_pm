package com.readboy.ssm.po;

/**
 * 分页工具类
 * @author:	   	LCL
 * @date: 	   	2017-9-23
 * @description:
 */
public class PageOption {
	
	private int showCount; // 每页显示记录数
	private int totalPage; // 总页数
	private int totalResult; // 总记录数
	private int currentPage; // 当前页
	private int currentResult; // 当前记录起始索引
	
	//PC端flag默认为true，APP端为false
	private boolean flag = true;
	
	public PageOption(){
		
	}
	
	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public PageOption(int x , int y){
		this.showCount = x;
		this.currentPage = y;
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	
	public int getTotalPage() {
		if(flag && showCount > 0){
			if (totalResult % showCount == 0)
				totalPage = totalResult / showCount;
			else
				totalPage = totalResult / showCount + 1;
			return totalPage;
		}
		return this.totalPage;
		
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	
	public int getCurrentPage() {
		if(flag){
			if (currentPage <= 0)
				currentPage = 1;
			if (currentPage > getTotalPage())
				currentPage = getTotalPage();
			return currentPage;
		}
		return this.currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//获取当前页的数据条的索引
	public int getCurrentResult() {
		if(flag){
			currentResult = (getCurrentPage() - 1) * getShowCount();
			if (currentResult < 0)
				currentResult = 0;
			return currentResult;
		}
		return this.currentResult;
	}
	
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	
	
	public static void initPage(PageOption page){
		if(page.getShowCount() == 0){
			page.setShowCount(10);
		}
		page.setTotalPage(page.getTotalPage());
		if(page.getCurrentPage() <= 0){
			page.setCurrentPage(1);
		}
		if(page.getCurrentPage() > page.getTotalPage()){
			page.setCurrentPage(page.getCurrentPage());
		}
		//设置查询结果集起始处
		page.setCurrentResult((page.getCurrentPage()-1)*page.getShowCount());
	}
	
	public static void initAppPage(PageOption page){
		if(page == null){
			page = new PageOption();
			page.setFlag(false);
			page.setCurrentResult(0);
			page.setShowCount(5);
			return;
		}else{
			page.setFlag(false);
			if(page.getCurrentResult() < 0){
				page.setCurrentResult(0);
			}
			if(page.getShowCount() <= 0){
				page.setShowCount(5);
			}
		}
	}
	
}

