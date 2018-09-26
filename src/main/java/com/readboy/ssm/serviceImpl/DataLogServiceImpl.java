package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.DataLogMapper;
import com.readboy.ssm.po.DataLog;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.DataLogService;

public class DataLogServiceImpl implements DataLogService {
	
	@Autowired
	private DataLogMapper dataLogMapper;
	
	@Override
	public Integer insertDataLog(DataLog dataLog) {
		// TODO Auto-generated method stub
		return dataLogMapper.insertDataLog(dataLog);
	}
	
	@Override
	public List<DataLog> findAllDataLog(String insert_time, String status,PageOption page) {
		// TODO Auto-generated method stub
		return dataLogMapper.findAllDataLog(insert_time,status,page);
	}
	
	@Override
	public Integer findDataCountByCond(String insert_time, String status) {
		// TODO Auto-generated method stub
		return dataLogMapper.findDataCountByCond(insert_time, status);
	}
	
	

}
