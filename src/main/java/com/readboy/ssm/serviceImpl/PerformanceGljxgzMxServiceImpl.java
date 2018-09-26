package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGljxgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGljxgzMx;
import com.readboy.ssm.service.PerformanceGljxgzMxService;
/*
 * 工资_业务量明细
 * */
public class PerformanceGljxgzMxServiceImpl implements PerformanceGljxgzMxService{
	
	@Autowired 
	private PerformanceGljxgzMxMapper performanceGljxgzMxMapper;

	@Override
	public List<PerformanceGljxgzMx> findPerformanceGljxgzMx(String yggh,
			String tjrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceGljxgzMxMapper.findPerformanceGljxgzMx(yggh, tjrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String tjrq) throws Exception {
		// TODO Auto-generated method stub
		Integer num =  performanceGljxgzMxMapper.findDataCountByCond(yggh, tjrq);
		return num != null ? num : 0;
	}
}
