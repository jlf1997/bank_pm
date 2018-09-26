package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanExpireDetail;
import com.readboy.ssm.po.SimpleBSNewAddBadLoanDetail;

public interface SimpleBSNewAddBadLoanDetailService {
	
	//查询包收贷款到期明细
	public List<SimpleBSNewAddBadLoanDetail> findSimpleBSNewAddBadLoanDetail(
			String bsrgh,String ksrq,String dqrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String dqrq) throws Exception;
	
}
