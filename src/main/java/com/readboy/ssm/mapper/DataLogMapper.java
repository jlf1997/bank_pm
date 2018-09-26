package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DataLog;
import com.readboy.ssm.po.PageOption;

public interface DataLogMapper {
	
	public Integer insertDataLog(DataLog dataLog);
	
	public List<DataLog> findAllDataLog(@Param("insert_time") String insert_time,
			@Param("status") String status,@Param("page") PageOption page);
	
	public Integer findDataCountByCond(@Param("insert_time") String insert_time,
			@Param("status") String status);
}
