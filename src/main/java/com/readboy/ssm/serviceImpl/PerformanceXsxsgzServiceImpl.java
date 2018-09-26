package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceXsxsgzMapper;
import com.readboy.ssm.po.PerformanceXsxsgz;
import com.readboy.ssm.service.PerformanceXsxsgzService;


public class PerformanceXsxsgzServiceImpl implements PerformanceXsxsgzService{
	
	@Autowired
	private PerformanceXsxsgzMapper performanceXsxsgzMapper;

	@Override
	public PerformanceXsxsgz findPerformanceXsxsgz(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceXsxsgzMapper.findPerformanceXsxsgz(yggh, ksrq, jsrq,zbid);
	}
	
}
