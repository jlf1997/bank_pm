package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PerformanceJgaljc;

public interface PerformanceJgaljcMapper {
	
	public PerformanceJgaljc findPerformanceJgaljc(@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("yggh") String yggh,
			@Param("zbid") String zbid) throws Exception;
}