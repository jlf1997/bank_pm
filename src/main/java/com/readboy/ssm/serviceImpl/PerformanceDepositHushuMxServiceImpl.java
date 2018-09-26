package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceDepositHushuMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDepositHushuMx;
import com.readboy.ssm.service.PerformanceDepositHushuMxService;

public class PerformanceDepositHushuMxServiceImpl implements PerformanceDepositHushuMxService{
	
	@Autowired
	private PerformanceDepositHushuMxMapper performanceDepositHushuMxMapper;
	
	@Override
	public List<PerformanceDepositHushuMx> findPerformanceDepositHushuMx(
			String yggh, String tjrq, String lx,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceDepositHushuMxMapper.findPerformanceDepositHushuMx(yggh, tjrq, lx,condition,page);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String tjrq, String lx,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceDepositHushuMxMapper.findDataCountByCond(yggh, tjrq, lx, condition);
		return num != null ? num : 0;
	}

}
