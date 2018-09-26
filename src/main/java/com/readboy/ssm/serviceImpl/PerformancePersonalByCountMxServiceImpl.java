package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformancePersonalByCountMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePersonalByCountMx;
import com.readboy.ssm.service.PerformancePersonalByCountMxService;

public class PerformancePersonalByCountMxServiceImpl implements PerformancePersonalByCountMxService{
	
	@Autowired 
	private PerformancePersonalByCountMxMapper performancePersonalByCountMxMapper;

	@Override
	public List<PerformancePersonalByCountMx> findPerformancePersonalByCountMx(
			String yggh, String ksrq, String jsrq,String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performancePersonalByCountMxMapper.findPerformancePersonalByCountMx(yggh, ksrq,jsrq, zbid);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String ksrq, String jsrq,
			String zbid) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performancePersonalByCountMxMapper.findDataCountByCond(yggh, ksrq, jsrq, zbid);
		return num != null ? num : 0;
	}


}
