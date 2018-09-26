package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceManageDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceManageDetail;
import com.readboy.ssm.service.PerformanceManageDetailService;
/*
 * 工资_业务量明细
 * */
public class PerformanceManageDetailServiceImpl implements PerformanceManageDetailService{
	
	@Autowired 
	private PerformanceManageDetailMapper performanceManageDetailMapper;

	@Override
	public List<PerformanceManageDetail> findPerformanceManageDetail(String yggh)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceManageDetailMapper.findPerformanceManageDetailByYggh(yggh);
	}

	@Override
	public Integer findDataCountByCond(String yggh) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceManageDetailMapper.findDataCountByCond(yggh);
		return num != null ? num : 0;
	}
}
