package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkmnlrgzMx;
/*
 * 绩效_存款模拟利润工资明细
 * */
public interface PerformanceCkmnlrgzMxMapper {
	
	public List<PerformanceCkmnlrgzMx> findPerformanceClCkmnlrgzMx(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("tableName") String tableName,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("condition") String condition
			,@Param("page") PageOption page
			)throws Exception;
	
	public Integer findClDataCount(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("tableName") String tableName,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("condition") String condition)throws Exception;
	
	public List<PerformanceCkmnlrgzMx> findPerformanceZlCkmnlrgzMx(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("tableName") String tableName,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("condition") String condition
			,@Param("page") PageOption page
			)throws Exception;
	
	public Integer findZlDataCount(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("tableName") String tableName,@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq,@Param("condition") String condition)throws Exception;
	
	//批量插入记录
	public long batchInsertPerformanceCkmnlrgzMx(@Param("tableName") String tableName,
			@Param("list") List<PerformanceCkmnlrgzMx> list) throws Exception;
	
	//创建表
	public long createTable(@Param(value="tableName") String tableName) throws Exception;
	
	//PC端按统计日期查询
	public List<PerformanceCkmnlrgzMx> findPerformanceCkmnlrgzMxByCondition(
			@Param("tableName") String tableName,
			@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("tableName") String tableName,
			@Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
	
	//分页查询，模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformanceCkmnlrgzMx(
				@Param("tableName") String tableName,
				@Param("start") long start,
				@Param("end") long end) throws Exception;
	
	//分页查询存量存款模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceClCkmnlrgzMxByCondition(
			@Param("tableName")String tableName,@Param("yxlx") int yxlx,
			@Param("start") long start,@Param("end") long end,
			@Param("condition") String condition
			) throws Exception;
	
	//分页查询增量存款模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceZlCkmnlrgzMxByCondition(
			@Param("tableName")String tableName,@Param("yxlx") int yxlx,
			@Param("start") long start,@Param("end") long end,
			@Param("condition") String condition
			) throws Exception;
	//获取记录条数
	public long getNoteCount(@Param("tableName") String tableName) throws Exception;
	
	//多条件查询确定唯一一条记录
	public PerformanceCkmnlrgzMx findOnePerformanceCkmnlrgzMx(
			@Param("tableName") String tableName,
			@Param("tjrq") String tjrq,
			@Param("zzbz") String zzbz,
			@Param("gwbz") long gwbz,
			@Param("yggh") String yggh,
			@Param("ckzh") String ckzh) throws Exception;
}
