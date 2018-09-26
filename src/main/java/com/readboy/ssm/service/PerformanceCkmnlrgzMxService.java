package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkmnlrgzMx;

public interface PerformanceCkmnlrgzMxService {
	
	//存量存款模拟利润
	public List<PerformanceCkmnlrgzMx> findPerformanceClCkmnlrgzMx(String yggh,
			int yxlx,String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findClDataCount(String yggh,
			int yxlx,String ksrq,String jsrq,String condition) throws Exception;

	//增量存款模拟利润
	public List<PerformanceCkmnlrgzMx> findPerformanceZlCkmnlrgzMx(String yggh,
			int yxlx,String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findZlDataCount(String yggh,
			int yxlx,String ksrq,String jsrq,String condition) throws Exception;
	
	//批量插入数据
	public long batchInsertPerformanceCkmnlrgzMx(String tableName,
			List<PerformanceCkmnlrgzMx> list) throws Exception;
	
	//创建表
	public long createTable(String tableName) throws Exception;
	
	//根据统计日期查询表
	public List<PerformanceCkmnlrgzMx> findPerformanceCkmnlrgzMxByCondition(
			String tableName,String ksrq,String jsrq) throws Exception;
	
	public int findDataCountByCond(String tableName,String ksrq,String jsrq) throws Exception;
	
	//分页查询：存款模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformanceCkmnlrgzMx(
				String tableName,long start,long end) throws Exception;
	
	//查询记录条数
	public long getNoteCount(String tableName) throws Exception;
	
	//多条件查询唯一记录
	public PerformanceCkmnlrgzMx findOnePerformanceCkmnlrgzMx(String tableName,
			String tjrq,String zzbz,long gwbz,String yggh,String ckzh) throws Exception;
	
	//分页查询存量存款模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceClCkmnlrgzMxByCondition(
			String tableName, int yxlx,long start, long end,String condition) throws Exception;
		
	//分页查询增量存款模拟利润工资明细
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceZlCkmnlrgzMxByCondition(
			String tableName, int yxlx,long start, long end,String condition) throws Exception;
	
}
