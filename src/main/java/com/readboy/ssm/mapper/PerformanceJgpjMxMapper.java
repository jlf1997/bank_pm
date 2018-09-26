package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgpjMx;
/*
 * 机构平均绩效工资明细
 * */
public interface PerformanceJgpjMxMapper {
	
	public List<PerformanceJgpjMx> findPerformanceJgpjMx(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq,@Param("zbid") String zbid) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq,@Param("zbid") String zbid) throws Exception;
}
