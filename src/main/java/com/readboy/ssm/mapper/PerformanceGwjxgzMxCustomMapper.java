package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGwjxgzMxCustom;
/*
 * 岗位绩效工资明细
 * */
public interface PerformanceGwjxgzMxCustomMapper {
	
	public List<PerformanceGwjxgzMxCustom> findPerformanceGwjxgzMxCustom(
			@Param("yggh") String yggh,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
}
