package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceDkKhhsMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkKhhsMx;
import com.readboy.ssm.service.PerformanceDkKhhsMxService;


public class PerformanceDkKhhsMxServiceImpl implements PerformanceDkKhhsMxService{
	
	@Autowired
	private PerformanceDkKhhsMxMapper performanceDkkhhsMxMapper;

	@Override
	public List<PerformanceDkKhhsMx> findPerformanceDkKhhsMx(String ksrq,
			String jsrq, String yggh, String condition, String lx,PageOption page)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceDkkhhsMxMapper.findPerformanceDkKhhsMx(ksrq, jsrq, yggh, condition, lx,page);
	}


	@Override
	public Integer findDataCountByCondition(String ksrq, String jsrq, String yggh,
			String condition, String lx) throws Exception {
		// TODO Auto-generated method stub
		Integer num =  performanceDkkhhsMxMapper.findDataCountByCondition(ksrq, jsrq, yggh, condition, lx);
		return num != null ? num : 0;
	}

	
}
