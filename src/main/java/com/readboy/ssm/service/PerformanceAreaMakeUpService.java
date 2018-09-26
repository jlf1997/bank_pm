package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAreaMakeUp;

/*
 * 绩效管理明细
 * */
public interface PerformanceAreaMakeUpService {
	
	public List<PerformanceAreaMakeUp> findPerformanceAreaMakeUp(
			String yggh,String ksrq,String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			String yggh,String ksrq,String jsrq) throws Exception;
	
}
