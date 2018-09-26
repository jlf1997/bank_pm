package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceJymbMapper;
import com.readboy.ssm.po.PerformanceJymb;
import com.readboy.ssm.service.PerformanceJymbService;

public class PerformanceJymbServiceImpl implements PerformanceJymbService{
	
	@Autowired
	private PerformanceJymbMapper performanceJymbMapper;
	@Override
	public PerformanceJymb findPerformanceJymb(String yggh, String gzrq,
			String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceJymbMapper.findPerformanceJymb(yggh, gzrq, zbid);
	}
	
}
