package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceAreaMakeUpMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAreaMakeUp;
import com.readboy.ssm.service.PerformanceAreaMakeUpService;
/*
 * 工资_业务量明细
 * */
public class PerformanceAreaMakeUpServiceImpl implements PerformanceAreaMakeUpService{
	
	@Autowired 
	private PerformanceAreaMakeUpMapper performanceAreaMakeUpMapper;

	@Override
	public List<PerformanceAreaMakeUp> findPerformanceAreaMakeUp(String yggh,
			String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceAreaMakeUpMapper.findPerformanceAreaMakeUp(yggh, ksrq, jsrq);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		 
		Integer num = performanceAreaMakeUpMapper.findDataCountByCond(yggh, ksrq, jsrq);
		return num != null ? num : 0;
	}

	
	

}
