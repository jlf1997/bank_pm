package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAljcgzMxCustom;

public interface PerformanceAljcgzMxCustomMapper {
	
	public List<PerformanceAljcgzMxCustom> findPerformanceAljcgzMxCustom(
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
