package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.LoanMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBusinessDetail;
/*
 * 工资_业务量明细
 * */
public interface PerformanceBusinessDetailMapper {
	
	public List<PerformanceBusinessDetail> findPerformanceBusinessDetail(
			@Param("yggh")String yggh,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh")String yggh,
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq) throws Exception;
	
}
