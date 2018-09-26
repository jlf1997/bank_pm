package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGljxBmkhMapper;
import com.readboy.ssm.po.PerformanceGljxBmkh;
import com.readboy.ssm.service.PerformanceGljxBmkhService;


public class PerformanceGljxBmkhServiceImpl implements PerformanceGljxBmkhService{
	
	@Autowired
	private PerformanceGljxBmkhMapper performanceGljxBmkhMapper;

	@Override
	public PerformanceGljxBmkh findPerformanceGljxBmkh(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceGljxBmkhMapper.findPerformanceGljxBmkh(ksrq, jsrq, yggh, zbid);
	}
	
}
