package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.ResMapper;
import com.readboy.ssm.po.Res;
import com.readboy.ssm.service.ResService;

public class ResServiceImpl implements ResService{
	
	@Autowired
	private ResMapper resMapper;
	@Override
	public Res findRes() throws Exception {
		// TODO Auto-generated method stub
		return resMapper.findRes();
	}

	@Override
	public long updateRes(String path) throws Exception {
		// TODO Auto-generated method stub
		return resMapper.updateRes(path);
	}

	@Override
	public long insertRes(String path) throws Exception {
		// TODO Auto-generated method stub
		return resMapper.insertRes(path);
	}
	
}	
