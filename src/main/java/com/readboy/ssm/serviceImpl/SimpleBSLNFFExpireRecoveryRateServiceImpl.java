package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleBSLNFFExpireRecoveryRateMapper;
import com.readboy.ssm.mapper.SimpleBSLoanOweInterestDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLNFFExpireRecoveryRate;
import com.readboy.ssm.po.SimpleBSLoanOweInterestDetail;
import com.readboy.ssm.service.SimpleBSLNFFExpireRecoveryRateService;

public class SimpleBSLNFFExpireRecoveryRateServiceImpl implements SimpleBSLNFFExpireRecoveryRateService{
	
	@Autowired
	private SimpleBSLNFFExpireRecoveryRateMapper simpleBSLNFFExpireRecoveryRateMapper;

	@Override
	public List<SimpleBSLNFFExpireRecoveryRate> findSimpleBSLNFFExpireRecoveryRate(
			String bsrgh, String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return simpleBSLNFFExpireRecoveryRateMapper.findSimpleBSLNFFExpireRecoveryRate(bsrgh, ksrq, jsrq);
	}

	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSLNFFExpireRecoveryRateMapper.findDataCountByCond(bsrgh, ksrq, jsrq);
		return num != null ? num : 0;
	}

}
