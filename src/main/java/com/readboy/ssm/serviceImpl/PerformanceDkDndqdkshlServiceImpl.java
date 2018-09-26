package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceDkDndqdkshlMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkDndqdkshl;
import com.readboy.ssm.service.PerformanceDkDndqdkshlService;


public class PerformanceDkDndqdkshlServiceImpl implements PerformanceDkDndqdkshlService{
	
	@Autowired
	private PerformanceDkDndqdkshlMapper performanceDkDndqdkshlMapper;

	@Override
	public PerformanceDkDndqdkshl findPerformanceDkDndqdkshl(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkDndqdkshlMapper.findPerformanceDkDndqdkshl(ksrq, jsrq, yggh, zbid);
	}

	@Override
	public Integer findDataCountByCond(String ksrq, String jsrq, String yggh,
			String zbid) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceDkDndqdkshlMapper.findDataCountByCond(ksrq, jsrq, yggh, zbid);
		return num != null ? num : 0;
	}

	

	
}
