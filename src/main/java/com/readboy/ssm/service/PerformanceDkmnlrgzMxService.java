package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;

public interface PerformanceDkmnlrgzMxService {
	
	public List<PerformanceDkmnlrgzMx> findPerformanceDkmnlrgzMx(String yggh,
			String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			String ksrq,String jsrq,String condition) throws Exception;
	//创建表
	public long createTable(String tableName) throws Exception;
	//批量插入数据
	public long batchInsertPerformanceDkmnlrgzMx(String tableName,List<PerformanceDkmnlrgzMx> list) throws Exception;
}
