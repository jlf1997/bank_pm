package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGljxWdrjgzMapper;
import com.readboy.ssm.po.PerformanceGljxWdrjgz;
import com.readboy.ssm.service.PerformanceGljxWdrjgzService;


public class PerformanceGljxWdrjgzServiceImpl implements PerformanceGljxWdrjgzService{
	
	@Autowired
	private PerformanceGljxWdrjgzMapper performanceGljxWdrjgzMapper;

	@Override
	public PerformanceGljxWdrjgz findPerformanceGljxWdrjgz(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceGljxWdrjgzMapper.findPerformanceGljxWdrjgz(ksrq, jsrq, yggh, zbid);
	}
	
}
