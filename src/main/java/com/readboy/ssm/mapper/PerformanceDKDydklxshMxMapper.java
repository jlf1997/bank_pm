package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDKDydklxshMx;

public interface PerformanceDKDydklxshMxMapper {
	
	public List<PerformanceDKDydklxshMx> findPerformanceDKDydklxshMx(@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("yggh") String yggh,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("yggh") String yggh,
			@Param("condition") String condition) throws Exception;
}