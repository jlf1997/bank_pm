package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkAljcgzMx;

public interface PerformanceDkAljcgzMxService {
	
	public List<PerformanceDkAljcgzMx> findPerformanceDkAljcgzMx(
		String tableName,String ksrq,String jsrq,String yggh,
		String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			String tableName,String ksrq,String jsrq,String yggh,
			String condition) throws Exception;
	
	public long createTable(String tableName) throws Exception;
}
