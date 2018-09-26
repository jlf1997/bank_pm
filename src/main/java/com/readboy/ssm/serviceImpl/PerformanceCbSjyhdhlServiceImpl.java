package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceCbSjyhdhlMapper;
import com.readboy.ssm.po.PerformanceCbSjyhdhl;
import com.readboy.ssm.service.PerformanceCbSjyjdhlService;


public class PerformanceCbSjyhdhlServiceImpl implements PerformanceCbSjyjdhlService{
	
	@Autowired
	private PerformanceCbSjyhdhlMapper performanceCbSjyhdhlMapper;

	@Override
	public PerformanceCbSjyhdhl findPerformanceCbSjyjdhl(String ksrq,
			String jsrq, String yggh, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceCbSjyhdhlMapper.findPerformanceCbSjyhdhl(ksrq, jsrq, yggh, zbid);
	}



	

	
}
