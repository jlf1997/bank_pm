package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceManageDetail;
/*
 * 管理绩效明细
 * */
public interface PerformanceManageDetailMapper {
	
	public List<PerformanceManageDetail> findPerformanceManageDetailByYggh(
			@Param("yggh") String yggh) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh) throws Exception;
	
}
