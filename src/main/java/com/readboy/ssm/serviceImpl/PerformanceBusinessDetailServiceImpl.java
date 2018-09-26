package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceBusinessDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBusinessDetail;
import com.readboy.ssm.service.PerformanceBusinessDetailService;
/*
 * 工资_业务量明细
 * */
public class PerformanceBusinessDetailServiceImpl implements PerformanceBusinessDetailService{
	
	@Autowired 
	private PerformanceBusinessDetailMapper performanceBusinessDetailMapper;
	@Override
	public List<PerformanceBusinessDetail> findPerformanceBusinessDetail(String yggh,
			String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		int len = ksrq.length();
		ksrq = ksrq.substring(0,len-2)+"01";
		return performanceBusinessDetailMapper.findPerformanceBusinessDetail(yggh, ksrq, jsrq);
	}
	@Override
	public Integer findDataCountByCond(String yggh, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceBusinessDetailMapper.findDataCountByCond(yggh, ksrq, jsrq);
		return num != null ? num : 0;
	}

}
