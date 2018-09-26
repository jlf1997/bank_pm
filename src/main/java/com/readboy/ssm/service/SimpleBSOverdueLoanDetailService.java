package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanOweInterestDetail;
import com.readboy.ssm.po.SimpleBSOverdueLoanDetail;

/*
 * 包收逾期贷款
 * */
public interface SimpleBSOverdueLoanDetailService {
	
	public List<SimpleBSOverdueLoanDetail> findSimpleBSOverdueLoanDetail(
		String bsrgh,String ksrq,String dqrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String dqrq) throws Exception;
	
}
