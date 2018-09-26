package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.DataLog;
import com.readboy.ssm.po.PageOption;

public interface DataLogService {
	
	public Integer insertDataLog(DataLog dataLog);
	
	public List<DataLog> findAllDataLog(String insert_time,String status,PageOption page);
	
	public Integer findDataCountByCond(String insert_time,String status);
}
