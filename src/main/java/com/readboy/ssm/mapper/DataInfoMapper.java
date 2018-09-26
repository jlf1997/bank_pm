package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;
public interface DataInfoMapper {
	
	//导入数据,返回值未知
	public long dataload(@Param("tableName") String tableName,
			@Param("fileDest") String fileDest,@Param("separator") String separator) throws Exception;
	
	//删除表记录
	public void deleteTableData(@Param("tableName")String tableName) throws Exception;
	
	//按天删除
	public void deleteTableDataByrq(
			@Param("tableName")String tableName,
			@Param("zd") String zd,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
	
	//删除营销申报中除新增的数据(yybh99开头,后面固定10位)
	public void deleteMarketingData(@Param("tableName") String tableName,
			@Param("minNum") long minNum) throws Exception;
	
	public long getDataCount(@Param("tableName") String tableName) throws Exception;
	
	
	//查询表是否存在
	public String findWheatherTableExist(@Param("tableName") String tableName) throws Exception;
	
}
