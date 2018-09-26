package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSDNFFExpireRecoveryRate;

/*
 * 包收当年发放当年到期收回率
 * */
public interface SimpleBSDNFFExpireRecoveryRateService {
	
	public List<SimpleBSDNFFExpireRecoveryRate> findSimpleBSDNFFExpireRecoveryRate(
			String bsrgh,String ksrq,String jsrq) throws Exception;
	
	public Integer findDataCountByCond(String bsrgh,String ksrq,String jsrq) throws Exception;
	
}
