package com.readboy.ssm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceDkmnlrgzMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkmnlrgzMx;
import com.readboy.ssm.service.PerformanceDkmnlrgzMxService;
import com.readboy.ssm.utils.Constants;
import com.readboy.ssm.utils.TableHelper;

public class PerformanceDkmnlrgzMxServiceImpl implements PerformanceDkmnlrgzMxService{
	
	@Autowired 
	private PerformanceDkmnlrgzMxMapper performanceDkmnlrgzMxMapper;

	@Override
	public List<PerformanceDkmnlrgzMx> findPerformanceDkmnlrgzMx(String yggh,
			String ksrq, String jsrq,String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_dkmnlrgzmx,ksrq);
		return performanceDkmnlrgzMxMapper.findPerformanceDkmnlrgzMx(yggh,tableName,ksrq, jsrq,condition,page);
	}

	@Override
	public long createTable(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkmnlrgzMxMapper.createTable(tableName);
	}

	@Override
	public long batchInsertPerformanceDkmnlrgzMx(String tableName,
			List<PerformanceDkmnlrgzMx> list) throws Exception {
		// TODO Auto-generated method stub
		return performanceDkmnlrgzMxMapper.batchInsertPerformanceDkmnlrgzMx(tableName,list);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String ksrq, String jsrq,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		String tableName = TableHelper.getTableNameByDate(Constants.table_dkmnlrgzmx,ksrq);
		Integer num =  performanceDkmnlrgzMxMapper.findDataCountByCond(yggh, tableName, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}
	
	
}
