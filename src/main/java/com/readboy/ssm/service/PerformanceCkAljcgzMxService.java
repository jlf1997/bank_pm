package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkAljcgzMx;

public interface PerformanceCkAljcgzMxService {
	
	public List<PerformanceCkAljcgzMx> findPerformanceCkAljcgzMx(
		String tableName,String ksrq,String jsrq,String yggh,
		String condition,String type,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			String tableName,String ksrq,String jsrq,String yggh,
			String condition,String type) throws Exception;
	
	public long createTable(String tableName) throws Exception;
	
}
