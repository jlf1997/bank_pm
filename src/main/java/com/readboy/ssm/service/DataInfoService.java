package com.readboy.ssm.service;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author:	   	LCL
 * @date: 	   	2017-7-8
 * @description:数据导入Service
 */
public interface DataInfoService {
	
	//数据导入
	public long dataload(String tableName,String fileDest,String separator) throws Exception;
	
	//删除表记录
	public void deleteTableData(String tableName) throws Exception;
	
	//按天删除
	public void deleteTableDataByrq(String tableName, String zd, String ksrq,String jsrq) throws Exception;
	
	//删除表记录
	public void deleteMarketingData(String tableName,long minNum) throws Exception;
	
	//获取记录条数
	public long getDataCount(String tableName) throws Exception;
	
	//查询表是否存在
	public String findWheatherTableExist(String tableName) throws Exception;
	
}
