package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGraljcMapper;
import com.readboy.ssm.po.PerformanceGraljc;
import com.readboy.ssm.service.PerformanceGraljcService;

public class PerformanceGraljcServiceImpl implements PerformanceGraljcService{
	
	@Autowired
	private PerformanceGraljcMapper performanceGraljcMapper;

	@Override
	public PerformanceGraljc findPerformanceGraljc(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceGraljcMapper.findPerformanceGraljc(ksrq, jsrq, yggh, zbid);
	}
	
}
