package com.readboy.ssm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceGxlgzMxCustomMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGxlgzMxCustom;
import com.readboy.ssm.service.PerformanceGxlgzMxCustomService;

public class PerformanceGxlgzMxCustomServiceImpl implements PerformanceGxlgzMxCustomService{
	
	@Autowired 
	private PerformanceGxlgzMxCustomMapper performanceGxlgzMxCustomMapper;

	@Override
	public List<PerformanceGxlgzMxCustom> findPerformanceGxlgzMxCustom(String yggh,
			String zzbz, String gwbz, String ksrq,String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceGxlgzMxCustomMapper.findPerformanceGxlgzMxCustom(yggh, zzbz, gwbz, ksrq,jsrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String zzbz, String gwbz,
			String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceGxlgzMxCustomMapper.findDataCountByCond(yggh, zzbz, gwbz, ksrq, jsrq);
		return num != null ? num : 0;
	}


}
