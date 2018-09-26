package com.readboy.ssm.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGzhzMapper;
import com.readboy.ssm.po.PerformanceGzhz;
import com.readboy.ssm.service.PerformanceGzhzService;
/*
 * 工资_业务量明细
 * */
public class PerformanceGzhzServiceImpl implements PerformanceGzhzService{
	
	@Autowired 
	private PerformanceGzhzMapper performanceGzhzMapper;

	@Override
	public PerformanceGzhz findPerformanceGzhz(String yggh, String ksrq,
			String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceGzhzMapper.findPerformanceGzhz(yggh, ksrq, jsrq);
	}

}
