package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceDkAljcgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkAljcgzMx;
import com.readboy.ssm.service.PerformanceDkAljcgzMxService;


public class PerformanceDkAljcgzMxServiceImpl implements PerformanceDkAljcgzMxService{
	
	@Autowired
	private PerformanceDkAljcgzMxMapper performanceDkAljcgzMxMapper;

	@Override
	public List<PerformanceDkAljcgzMx> findPerformanceDkAljcgzMx(
			String tableName, String ksrq, String jsrq, String yggh,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkAljcgzMxMapper.findPerformanceDkAljcgzMx(tableName, ksrq, jsrq, yggh, condition,page);
	}

	@Override
	public long createTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkAljcgzMxMapper.createTable(tableName);
	}

	@Override
	public Integer findDataCountByCond(String tableName, String ksrq, String jsrq,
			String yggh, String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer count = performanceDkAljcgzMxMapper.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition);
		if(count == null)
			return 0;
		return count;
	}


	
}
