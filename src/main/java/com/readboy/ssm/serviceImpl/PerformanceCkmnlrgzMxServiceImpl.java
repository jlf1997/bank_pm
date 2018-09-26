package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceCkmnlrgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCkmnlrgzMx;
import com.readboy.ssm.service.PerformanceCkmnlrgzMxService;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.TableHelper;


public class PerformanceCkmnlrgzMxServiceImpl implements PerformanceCkmnlrgzMxService{
	
	@Autowired 
	private PerformanceCkmnlrgzMxMapper performanceCkmnlrgzMxMapper;

	@Override
	public List<PerformanceCkmnlrgzMx> findPerformanceClCkmnlrgzMx(String yggh,
			int yxlx, String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,ksrq);
		return performanceCkmnlrgzMxMapper.findPerformanceClCkmnlrgzMx(yggh, yxlx,tableName, ksrq, jsrq,condition,page);
	}

	@Override
	public List<PerformanceCkmnlrgzMx> findPerformanceZlCkmnlrgzMx(String yggh,
			int yxlx, String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,ksrq);
		return performanceCkmnlrgzMxMapper.findPerformanceZlCkmnlrgzMx(yggh, yxlx,tableName, ksrq, jsrq,condition,page);
	}

	@Override
	public long batchInsertPerformanceCkmnlrgzMx(String tableName,
			List<PerformanceCkmnlrgzMx> list) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.batchInsertPerformanceCkmnlrgzMx(tableName,list);
	}

	@Override
	public long createTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.createTable(tableName);
	}

	@Override
	public List<PerformanceCkmnlrgzMx> findPerformanceCkmnlrgzMxByCondition(
			String tableName, String ksrq, String jsrq) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.findPerformanceCkmnlrgzMxByCondition(tableName, ksrq, jsrq);
	}

	@Override
	public List<PerformanceCkmnlrgzMx> pageFindPerformanceCkmnlrgzMx(
			String tableName,long start, long end) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.pageFindPerformanceCkmnlrgzMx(tableName,start,end);
	}

	@Override
	public long getNoteCount(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.getNoteCount(tableName);
	}

	@Override
	public PerformanceCkmnlrgzMx findOnePerformanceCkmnlrgzMx(String tableName,
			String tjrq, String zzbz, long gwbz, String yggh, String ckzh)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.findOnePerformanceCkmnlrgzMx(tableName,tjrq, zzbz, gwbz, yggh, ckzh);
	}

	@Override
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceClCkmnlrgzMxByCondition(
			String tableName, int yxlx, long start, long end, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.pageFindPerformaceClCkmnlrgzMxByCondition(tableName, yxlx, start, end, condition);
	}

	@Override
	public List<PerformanceCkmnlrgzMx> pageFindPerformaceZlCkmnlrgzMxByCondition(
			String tableName, int yxlx, long start, long end, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.pageFindPerformaceZlCkmnlrgzMxByCondition(tableName, yxlx, start, end, condition);
	}


	@Override
	public int findDataCountByCond(String tableName, String ksrq, String jsrq)
			throws Exception {
		// TODO Auto-generated method stub
		return performanceCkmnlrgzMxMapper.findDataCountByCond(tableName, ksrq, jsrq);
	}

	@Override
	public Integer findClDataCount(String yggh, int yxlx, String ksrq, String jsrq,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,ksrq);
		Integer num = performanceCkmnlrgzMxMapper.findClDataCount(yggh, yxlx, tableName, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}

	@Override
	public Integer findZlDataCount(String yggh, int yxlx, String ksrq, String jsrq,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_ckmnlrgzmx,ksrq);
		Integer num = performanceCkmnlrgzMxMapper.findZlDataCount(yggh, yxlx, tableName, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}
	
}
