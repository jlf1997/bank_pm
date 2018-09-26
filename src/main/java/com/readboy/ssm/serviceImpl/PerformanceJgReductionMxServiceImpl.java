package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceJgReductionMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgReductionMx;
import com.readboy.ssm.service.PerformanceJgReductionMxService;

public class PerformanceJgReductionMxServiceImpl implements PerformanceJgReductionMxService{
	
	@Autowired 
	private PerformanceJgReductionMxMapper performanceJgReductionMxMapper;

	@Override
	public List<PerformanceJgReductionMx> findPerformanceJgReductionMx(
			String yggh, String gzrq, String zbid) throws Exception {
		// TODO Auto-generated method stub
		return performanceJgReductionMxMapper.findPerformanceJgReductionMx(yggh, gzrq, zbid);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String gzrq, String zbid)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num =  performanceJgReductionMxMapper.findDataCountByCond(yggh, gzrq, zbid);
		return num != null ? num : 0;
	}


}
