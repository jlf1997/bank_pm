package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBlqsMx;

/*
 * 绩效_不良清收明细
 * */
public interface PerformanceBlqsMxMapper {
	
	public List<PerformanceBlqsMx> findPerformanceBlqsMx(
			@Param("shrgh") String shrgh,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition
			,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("shrgh") String shrgh,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
}
