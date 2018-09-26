package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;

public interface PerformancePhjfkgzMxCustomMapper {
	
	public List<PerformancePhjfkgzMxCustom> findPerformancePhjfkgzMxCustom(
			@Param("yggh") String yggh,
			@Param("zzbz") String zzbz,
			@Param("gwbz") String gwbz,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,
			@Param("zzbz") String zzbz,
			@Param("gwbz") String gwbz,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq) throws Exception;
	
}
