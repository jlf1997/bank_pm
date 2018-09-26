package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAreaMakeUp;
/*
 * 管理绩效明细
 * */
public interface PerformanceAreaMakeUpMapper {
	
	public List<PerformanceAreaMakeUp> findPerformanceAreaMakeUp(
			@Param("yggh")String yggh,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh")String yggh,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq) throws Exception;
	
//	public int findPerformanceAreaMakeUp(
//			@Param("yggh")String yggh,
//			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq) throws Exception;
	
}
