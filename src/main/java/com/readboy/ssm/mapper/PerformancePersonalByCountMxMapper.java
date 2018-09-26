package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePersonalByCountMx;
/*
 * 管理绩效明细
 * */
public interface PerformancePersonalByCountMxMapper {
	
	public List<PerformancePersonalByCountMx> findPerformancePersonalByCountMx(
			@Param("yggh") String yggh,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("zbid") String zbid) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("zbid") String zbid) throws Exception;
}
