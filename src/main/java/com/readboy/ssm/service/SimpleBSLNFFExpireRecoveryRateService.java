package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLNFFExpireRecoveryRate;

public interface SimpleBSLNFFExpireRecoveryRateService {
	
	//查询包收贷款欠息明细
	public List<SimpleBSLNFFExpireRecoveryRate> findSimpleBSLNFFExpireRecoveryRate(
			String bsrgh,String ksrq,String jsrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String jsrq) throws Exception;
}
