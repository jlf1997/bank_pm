package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkAljcgzMx;

public interface PerformanceCkAljcgzMxMapper {
	
	public List<PerformanceCkAljcgzMx> findPerformanceCkAljcgzMx(
			@Param("tableName")String tableName,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq,
			@Param("yggh")String yggh,@Param("condition")String condition,
			@Param("type")String type,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("tableName")String tableName,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq,
			@Param("yggh")String yggh,@Param("condition")String condition,
			@Param("type")String type) throws Exception;
	
	public long createTable(@Param("tableName") String tableName) throws Exception;
}