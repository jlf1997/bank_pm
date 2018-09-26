package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceYwlWdywlMapper;
import com.readboy.ssm.po.PerformanceYwlWdywl;
import com.readboy.ssm.service.PerformanceYwlWdywlService;

public class PerformanceYwlWdywlServiceImpl implements PerformanceYwlWdywlService{
	
	@Autowired
	private PerformanceYwlWdywlMapper performanceYwlWdywlMapper;

	@Override
	public PerformanceYwlWdywl findPerformanceYwlWdywl(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceYwlWdywlMapper.findPerformanceYwlWdywl(ksrq, jsrq, yggh, zbid);
	}
	
}
