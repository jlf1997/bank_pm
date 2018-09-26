package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PerformanceGzhz;

public interface PerformanceGzhzMapper {
	
	public PerformanceGzhz findPerformanceGzhz(
			@Param("yggh") String yggh, @Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception; 
	
	
}
