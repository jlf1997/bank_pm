package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBusinessDetail;
/*
 * 工资_业务量明细
 * */
public interface PerformanceBusinessDetailService {
	
	public List<PerformanceBusinessDetail> findPerformanceBusinessDetail(
			String yggh,String ksrq,String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			String yggh,String ksrq,String jsrq) throws Exception;
}
