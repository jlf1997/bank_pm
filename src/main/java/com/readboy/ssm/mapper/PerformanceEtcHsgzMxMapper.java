package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceEtcHsgzMx;
/*
 * 管理绩效明细
 * */
public interface PerformanceEtcHsgzMxMapper {
	
	public List<PerformanceEtcHsgzMx> findPerformanceEtcHsgzMx(
			@Param("yggh") String yggh,@Param("ghlx") int ghlx,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition,
			@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("ghlx") int ghlx,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
}
