package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PerformanceXsxsgz;

public interface PerformanceXsxsgzMapper {
  
	public PerformanceXsxsgz findPerformanceXsxsgz(
			@Param("yggh") String yggh, @Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("zbid") String zbid) throws Exception; 
}