package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceEtcHsgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceEtcHsgzMx;
import com.readboy.ssm.service.PerformanceEtcHsgzMxService;


public class PerformanceEtcHsgzMxServiceImpl implements PerformanceEtcHsgzMxService{
	
	@Autowired 
	private PerformanceEtcHsgzMxMapper performanceEtcHsgzMxMapper;

	@Override
	public List<PerformanceEtcHsgzMx> findPerformanceEtcHsgzMx(String yggh,
			int ghlx, String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceEtcHsgzMxMapper.findPerformanceEtcHsgzMx(yggh, ghlx, ksrq, jsrq,condition,page);
	}

	@Override
	public Integer findDataCountByCond(String yggh, int ghlx, String ksrq,
			String jsrq, String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceEtcHsgzMxMapper.findDataCountByCond(yggh, ghlx, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}


}
