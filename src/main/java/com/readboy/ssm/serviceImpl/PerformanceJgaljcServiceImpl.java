package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceJgaljcMapper;
import com.readboy.ssm.po.PerformanceJgaljc;
import com.readboy.ssm.service.PerformanceJgaljcService;


public class PerformanceJgaljcServiceImpl implements PerformanceJgaljcService{
	
	@Autowired
	private PerformanceJgaljcMapper performanceJgaljcMapper;

	@Override
	public PerformanceJgaljc findPerformanceJgaljc(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceJgaljcMapper.findPerformanceJgaljc(ksrq, jsrq, yggh, zbid);
	}
	
}
