package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGljxgzMx;

/*
 * 绩效管理明细
 * */
public interface PerformanceGljxgzMxService {
	
	public List<PerformanceGljxgzMx> findPerformanceGljxgzMx(
			String yggh,String tjrq) throws Exception;
	
	public Integer findDataCountByCond(String yggh,String tjrq) throws Exception;
}
