package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceCbBmkkhhsMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCbBmkkhhsMx;
import com.readboy.ssm.service.PerformanceCbBmkkhhsMxService;


public class PerformanceCbBmkkhhsMxServiceImpl implements PerformanceCbBmkkhhsMxService{
	
	@Autowired
	private PerformanceCbBmkkhhsMxMapper performanceCbBmkkhhsMxMapper;

	@Override
	public List<PerformanceCbBmkkhhsMx> findPerformanceCbBmkkhhsMx(
			String ksrq, String jsrq, String yggh, String condition,PageOption page)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceCbBmkkhhsMxMapper.findPerformanceCbBmkkhhsMx(ksrq, jsrq, yggh, condition,page);
	}

	@Override
	public Integer findDataCountByCond(String ksrq, String jsrq, String yggh,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num =  performanceCbBmkkhhsMxMapper.findDataCountByCond(ksrq, jsrq, yggh, condition);
		return num != null ? num : 0;
	}
	
}
