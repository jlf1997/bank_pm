package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgReductionMx;
/*
 * 管理绩效明细
 * */
public interface PerformanceJgReductionMxMapper {
	
	public List<PerformanceJgReductionMx> findPerformanceJgReductionMx(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq,@Param("zbid") String zbid) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq,@Param("zbid") String zbid) throws Exception;
}
