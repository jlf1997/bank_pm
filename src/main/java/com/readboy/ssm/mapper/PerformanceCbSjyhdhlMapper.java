package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCbSjyhdhl;

public interface PerformanceCbSjyhdhlMapper {
    
	public PerformanceCbSjyhdhl findPerformanceCbSjyhdhl(@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,
			@Param("yggh") String yggh,@Param("zbid") String zbid) throws Exception;
}