package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.LoanMarketing;

public interface LoanMarketingService {
	
	//删除一条存款营销登记记录
	public void deleteOneLoanMarketingByYybh(int yybh) throws Exception;
	//获取一条存款营销登记记录
	public LoanMarketing findLoanMarketingByYybh(int yybh) throws Exception;
	
	//获取所有存款营销登记
	public List<LoanMarketing> findAllLoanMarketing() throws Exception;
	
	//更新存款营销登记记录
	public void updateLoanMarketing(LoanMarketing loanMarketing) throws Exception;
	
	//插入数据
	public int insertLoanMarketing(LoanMarketing loanMarketing) throws Exception;

}
