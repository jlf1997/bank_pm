package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceManageDetail;

/*
 * 绩效管理明细
 * */
public interface PerformanceManageDetailService {
	
	public List<PerformanceManageDetail> findPerformanceManageDetail(
			String yggh) throws Exception;
	
	public Integer findDataCountByCond(
			String yggh) throws Exception;
}
