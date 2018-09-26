package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkKhhsMx;

public interface PerformanceDkKhhsMxMapper {
	
	public List<PerformanceDkKhhsMx> findPerformanceDkKhhsMx(
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq,
			@Param("yggh")String yggh,@Param("condition")String condition,
			@Param("lx")String lx,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCondition(
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq,
			@Param("yggh")String yggh,@Param("condition")String condition,
			@Param("lx")String lx) throws Exception;
}