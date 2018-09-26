package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceBlqsMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBlqsMx;
import com.readboy.ssm.service.PerformanceBlqsMxService;


public class PerformanceBlqsMxServiceImpl implements PerformanceBlqsMxService{
	
	@Autowired 
	private PerformanceBlqsMxMapper performanceBlqsMxMapper;

	@Override
	public List<PerformanceBlqsMx> findPerformanceBlqsMx(String shrgh,
			String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceBlqsMxMapper.findPerformanceBlqsMx(shrgh, ksrq, jsrq,condition,page);
	}

	@Override
	public Integer findDataCountByCond(String shrgh, String ksrq, String jsrq,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num =  performanceBlqsMxMapper.findDataCountByCond(shrgh, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}
}
