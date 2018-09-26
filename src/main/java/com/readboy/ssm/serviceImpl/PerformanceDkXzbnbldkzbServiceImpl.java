package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceDkXzbnbldkzbMapper;
import com.readboy.ssm.po.PerformanceDkXzbnbldkzb;
import com.readboy.ssm.service.PerformanceDkXzbnbldkzbService;


public class PerformanceDkXzbnbldkzbServiceImpl implements PerformanceDkXzbnbldkzbService{
	
	@Autowired
	private PerformanceDkXzbnbldkzbMapper performanceDkXzbnbldkzbMapper;

	@Override
	public PerformanceDkXzbnbldkzb findPerformanceDkXzbnbldkzb(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkXzbnbldkzbMapper.findPerformanceDkXzbnbldkzb(ksrq, jsrq, yggh, zbid);
	}

	

	
}
