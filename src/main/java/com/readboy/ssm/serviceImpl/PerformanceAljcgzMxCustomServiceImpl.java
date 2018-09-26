package com.readboy.ssm.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceAljcgzMxCustomMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAljcgzMxCustom;
import com.readboy.ssm.service.PerformanceAljcgzMxCustomService;

public class PerformanceAljcgzMxCustomServiceImpl implements PerformanceAljcgzMxCustomService{
	
	@Autowired 
	private PerformanceAljcgzMxCustomMapper performanceAljcgzMxCustomMapper;

	@Override
	public List<PerformanceAljcgzMxCustom> findPerformanceAljcgzMxCustom(String yggh,
			String zzbz, String gwbz, String ksrq,String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceAljcgzMxCustomMapper.findPerformanceAljcgzMxCustom(yggh, zzbz, gwbz, ksrq,jsrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String zzbz, String gwbz,
			String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceAljcgzMxCustomMapper.findDataCountByCond(yggh, zzbz, gwbz, ksrq, jsrq);
		return num != null ? num : 0;
	}


}
