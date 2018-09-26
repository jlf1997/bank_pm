package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.AreaMapper;
import com.readboy.ssm.po.Area;
import com.readboy.ssm.service.AreaService;

public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaMapper areaMapper;
	@Override
	public Area findArea() throws Exception {
		// TODO Auto-generated method stub
		return areaMapper.findArea();
	}
	
}
