package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceDKDydklxshMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDKDydklxshMx;
import com.readboy.ssm.service.PerformanceDkDydklxshMxService;


public class PerformanceDkDydklxshMxServiceImpl implements PerformanceDkDydklxshMxService{
	@Autowired
	private PerformanceDKDydklxshMxMapper performanceDkDydklxshMxMapper;

	@Override
	public List<PerformanceDKDydklxshMx> findPerformanceDKDydklxshMx(
			String ksrq, String jsrq, String yggh,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkDydklxshMxMapper.findPerformanceDKDydklxshMx(ksrq, jsrq, yggh, condition,page);
	}

	@Override
	public Integer findDataCountByCond(String ksrq, String jsrq, String yggh,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceDkDydklxshMxMapper.findDataCountByCond(ksrq, jsrq, yggh, condition);
		return num != null ? num : 0;
	}

	

	
}
