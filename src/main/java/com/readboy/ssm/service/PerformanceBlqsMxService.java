package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBlqsMx;

/*
 * 绩效管理明细
 * */
public interface PerformanceBlqsMxService {
	
	public List<PerformanceBlqsMx> findPerformanceBlqsMx(
			String shrgh,String ksrq,String jsrq,String condition
			,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			String shrgh,String ksrq,String jsrq,String condition) throws Exception;
}
