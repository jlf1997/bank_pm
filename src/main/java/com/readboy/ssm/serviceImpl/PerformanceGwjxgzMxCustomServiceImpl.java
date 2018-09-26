package com.readboy.ssm.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGwjxgzMxCustomMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGwjxgzMxCustom;
import com.readboy.ssm.service.PerformanceGwjxgzMxCustomService;
/*
 * 岗位绩效工资明细自定义Service
 * */
public class PerformanceGwjxgzMxCustomServiceImpl implements PerformanceGwjxgzMxCustomService{
	
	@Autowired 
	private PerformanceGwjxgzMxCustomMapper performanceGwjxgzMxCustomMapper;

	@Override
	public List<PerformanceGwjxgzMxCustom> findPerformanceGwjxgzMxCustom(String yggh, String ksrq,
			String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceGwjxgzMxCustomMapper.findPerformanceGwjxgzMxCustom(yggh, ksrq, jsrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceGwjxgzMxCustomMapper.findDataCountByCond(yggh, ksrq, jsrq);
		return num != null ? num : 0;
	}

}
