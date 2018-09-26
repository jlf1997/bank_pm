package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PerformanceCkYzkhgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkYzkhgzMx;
import com.readboy.ssm.service.PerformanceCkYzkhgzMxService;

public class PerformanceCkYzkhgzMxServiceImpl implements PerformanceCkYzkhgzMxService{
	
	@Autowired
	private PerformanceCkYzkhgzMxMapper performanceCkYzkhgzMxMapper;
	@Override
	public List<PerformanceCkYzkhgzMx> findPerformanceCkYzkhgzMx(
			String tableName, String ksrq, String jsrq, String yggh,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkYzkhgzMxMapper.findPerformanceCkYzkhgzMx(tableName, ksrq, jsrq, yggh, condition,page);
	}
	@Override
	public long createTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkYzkhgzMxMapper.createTable(tableName);
	}
	@Override
	public Integer findDataCount(String tableName, String ksrq, String jsrq,
			String yggh, String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceCkYzkhgzMxMapper.findDataCountByCond(tableName, ksrq, jsrq, yggh, condition);
		return num != null ? num : 0;
	}
	
}
