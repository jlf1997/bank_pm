package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDepositHushuMx;

public interface PerformanceDepositHushuMxMapper {

	public List<PerformanceDepositHushuMx> findPerformanceDepositHushuMx(
			@Param("yggh") String yggh,
			@Param("tjrq") String tjrq,
			@Param("lx") String lx,
			@Param("condition") String condition
			,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,
			@Param("tjrq") String tjrq,
			@Param("lx") String lx,
			@Param("condition") String condition) throws Exception;

}
