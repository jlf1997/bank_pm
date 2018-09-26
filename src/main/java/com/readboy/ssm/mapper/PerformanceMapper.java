package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.Performance;

public interface PerformanceMapper {

	public Performance findPerformance(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq) throws Exception;

	//查询绩效工资汇总表
	public List<Performance> findAllPerformance() throws Exception;
	
}
