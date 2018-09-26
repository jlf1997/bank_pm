package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceCkAljcgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkAljcgzMx;
import com.readboy.ssm.service.PerformanceCkAljcgzMxService;

public class PerformanceCkAljcgzMxServiceImpl implements PerformanceCkAljcgzMxService{
	
	@Autowired
	private PerformanceCkAljcgzMxMapper performanceCkAljcgzMxMapper;
	@Override
	public List<PerformanceCkAljcgzMx> findPerformanceCkAljcgzMx(
			String tableName, String ksrq, String jsrq, String yggh,
			String condition, String type,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkAljcgzMxMapper.findPerformanceCkAljcgzMx(tableName, ksrq, jsrq, yggh, condition, type,page);
	}
	@Override
	public long createTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkAljcgzMxMapper.createTable(tableName);
	}
	@Override
	public Integer findDataCountByCond(String tableName, String ksrq, String jsrq,
			String yggh, String condition, String type) throws Exception {
		// TODO Auto-generated method stub
		
		Integer num = performanceCkAljcgzMxMapper.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition, type);
		return num != null ? num : 0;
	}
	
}
