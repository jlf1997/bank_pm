package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceMapper;
import com.readboy.ssm.mapper.PerformanceMxMapper;
import com.readboy.ssm.po.Performance;
import com.readboy.ssm.po.PerformanceMx;
import com.readboy.ssm.service.PerformanceMxService;

public class PerformanceMxServiceImpl implements PerformanceMxService{
	
	@Autowired 
	private PerformanceMxMapper performanceMapper;

	@Override
	public List<PerformanceMx> findPerformanceMx(String yggh, String gzrq, int zblb)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceMapper.findPerformanceMx(yggh, gzrq, zblb);
	}
	
	
}
