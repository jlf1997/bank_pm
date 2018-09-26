package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;
/*
 * 绩效_贷款模拟利润工资明细
 * */
public interface PerformanceDkmnlrgzMxMapper {
	
	public List<PerformanceDkmnlrgzMx> findPerformanceDkmnlrgzMx(
			@Param("yggh") String yggh,@Param("tableName") String tableName,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("tableName") String tableName,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
	
	//创建表
	public long createTable(@Param(value="tableName") String tableName) throws Exception;
	
	//批量插入数据
	public long batchInsertPerformanceDkmnlrgzMx(@Param(value="tableName") String tableName,
			@Param(value="list") List<PerformanceDkmnlrgzMx> list) throws Exception;
}
