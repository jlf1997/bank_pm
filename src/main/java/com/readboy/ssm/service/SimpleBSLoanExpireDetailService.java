package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanExpireDetail;

public interface SimpleBSLoanExpireDetailService {
	
	//查询包收贷款到期明细
	public List<SimpleBSLoanExpireDetail> findSimpleBSLoanExpireDetail(
			String bsrgh,String ksrq,String dqrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String dqrq) throws Exception;
	
}
