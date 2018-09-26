package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkDndqdkshl;

public interface PerformanceDkDndqdkshlMapper {
    
	public PerformanceDkDndqdkshl findPerformanceDkDndqdkshl(
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("yggh") String yggh,@Param("zbid") String zbid) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("yggh") String yggh,@Param("zbid") String zbid) throws Exception;
}