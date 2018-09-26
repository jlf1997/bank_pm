package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanOweInterestDetail;

public interface SimpleBSLoanOweInterestDetailService {
	
	//查询包收贷款欠息明细
	public List<SimpleBSLoanOweInterestDetail> findSimpleBSLoanOweInterestDetail(
			String bsrgh,String ksrq,String dqrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String dqrq) throws Exception;
	
}
