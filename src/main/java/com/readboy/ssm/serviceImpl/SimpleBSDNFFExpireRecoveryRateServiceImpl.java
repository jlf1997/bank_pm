package com.readboy.ssm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.SimpleBSDNFFExpireRecoveryRateMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSDNFFExpireRecoveryRate;
import com.readboy.ssm.service.SimpleBSDNFFExpireRecoveryRateService;

public class SimpleBSDNFFExpireRecoveryRateServiceImpl implements SimpleBSDNFFExpireRecoveryRateService{
	
	@Autowired
	private SimpleBSDNFFExpireRecoveryRateMapper simpleBSDNFFExpireRecoveryRateMapper;

	@Override
	public List<SimpleBSDNFFExpireRecoveryRate> findSimpleBSDNFFExpireRecoveryRate(
			String bsrgh, String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return simpleBSDNFFExpireRecoveryRateMapper.findSimpleBSDNFFExpireRecoveryRate(bsrgh, ksrq, jsrq);
	}

	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSDNFFExpireRecoveryRateMapper.findDataCountByCond(bsrgh, ksrq, jsrq);
		return num != null ? num : 0;
	}

}
