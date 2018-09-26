package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGljxgzMx;

public interface PerformanceGljxgzMxMapper {
	
	public List<PerformanceGljxgzMx> findPerformanceGljxgzMx(
			@Param("yggh") String yggh, @Param("tjrq") String tjrq) throws Exception; 
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh, @Param("tjrq") String tjrq) throws Exception; 
}
