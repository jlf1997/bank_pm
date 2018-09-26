package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceMapper;
import com.readboy.ssm.po.Performance;
import com.readboy.ssm.service.PerformanceService;

public class PerformanceServiceImpl implements PerformanceService{
	
	@Autowired 
	private PerformanceMapper performanceMapper;

	@Override
	public Performance findPerformance(String yggh, String gzrq)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceMapper.findPerformance(yggh, gzrq);
	}

	@Override
	public List<Performance> findAllPerformance() throws Exception {
		// TODO Auto-generated method stub
		return performanceMapper.findAllPerformance();
	}
	
	
}
