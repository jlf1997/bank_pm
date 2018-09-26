package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGzzlMapper;
import com.readboy.ssm.po.PerformanceGzzl;
import com.readboy.ssm.service.PerformanceGzzlService;


public class PerformanceGzzlServiceImpl implements PerformanceGzzlService{
	
	@Autowired
	private PerformanceGzzlMapper performanceGzzlMapper;

	@Override
	public PerformanceGzzl findPerformanceGzzl(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceGzzlMapper.findPerformanceGzzl(ksrq, jsrq, yggh, zbid);
	}
	
}
