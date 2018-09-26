package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkKhhsMx;

public interface PerformanceDkKhhsMxService {
	
	public List<PerformanceDkKhhsMx> findPerformanceDkKhhsMx(
		String ksrq,String jsrq,String yggh,
		String condition,String lx,PageOption page) throws Exception;
	
	public Integer findDataCountByCondition(
			String ksrq,String jsrq,String yggh,
			String condition,String lx) throws Exception;
}
