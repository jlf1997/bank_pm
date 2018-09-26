package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PerformanceDkXzbnbldkzb;

public interface PerformanceDkXzbnbldkzbMapper {
	
	public PerformanceDkXzbnbldkzb findPerformanceDkXzbnbldkzb(@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("yggh") String yggh,@Param("zbid") String zbid) throws Exception;
}