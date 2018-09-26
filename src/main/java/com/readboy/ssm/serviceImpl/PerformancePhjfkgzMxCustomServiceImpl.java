package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformancePhjfkgzMxCustomMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;

import com.readboy.ssm.service.PerformancePhjfkgzMxCustomService;


public class PerformancePhjfkgzMxCustomServiceImpl implements PerformancePhjfkgzMxCustomService{
	
	@Autowired 
	private PerformancePhjfkgzMxCustomMapper performancePhjfkgzMxCustomMapper;

	@Override
	public List<PerformancePhjfkgzMxCustom> findPerformancePhjfkgzMxCustom(String yggh,
			String zzbz, String gwbz, String ksrq,String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performancePhjfkgzMxCustomMapper.findPerformancePhjfkgzMxCustom(yggh, zzbz, gwbz, ksrq,jsrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String zzbz, String gwbz,
			String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performancePhjfkgzMxCustomMapper.findDataCountByCond(yggh, zzbz, gwbz, ksrq, jsrq);
		return num != null ? num : 0;
	}


}
