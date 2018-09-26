package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleDepositExpireDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleDepositExpireDetail;
import com.readboy.ssm.service.SimpleDepositExpireDetailService;

public class SimpleDepositExpireDetailServiceImpl implements SimpleDepositExpireDetailService{
	
	@Autowired
	SimpleDepositExpireDetailMapper simpleDepositExpireDetailMapper;
	@Override
	public List<SimpleDepositExpireDetail> findDepositExpireDetail(
			String tzrgh, String ksrq , String dqrq) throws Exception {
		// TODO Auto-generated method stub
		return simpleDepositExpireDetailMapper.findDepositExpireDetail(tzrgh,ksrq,dqrq);
	}
	
	@Override
	public Integer findDataCountByCond(String tzrgh, String ksrq, String dqrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleDepositExpireDetailMapper.findDataCountByCond(tzrgh, ksrq, dqrq);
		return num != null ? num : 0;
	}


}
