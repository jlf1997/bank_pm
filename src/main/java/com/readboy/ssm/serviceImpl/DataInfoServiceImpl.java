package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.DataInfoMapper;
import com.readboy.ssm.service.DataInfoService;

public class DataInfoServiceImpl implements DataInfoService{
	
	@Autowired
	private DataInfoMapper dataInfoMapper;
	
	@Override
	public long dataload(String tableName, String fileDest,String separator) throws Exception {
		// TODO Auto-generated method stub
		return dataInfoMapper.dataload(tableName, fileDest,separator);
	}

	@Override
	public void deleteTableData(String tableName) throws Exception {
		// TODO Auto-generated method stub
		dataInfoMapper.deleteTableData(tableName);
	}

	@Override
	public void deleteMarketingData(String tableName, long minNum)
			throws Exception {
		// TODO Auto-generated method stub
		dataInfoMapper.deleteMarketingData(tableName, minNum);
	}

	@Override
	public void deleteTableDataByrq(String tableName, String zd, String ksrq,
			String jsrq) throws Exception {
		// TODO Auto-generated method stub
		dataInfoMapper.deleteTableDataByrq(tableName, zd, ksrq, jsrq);
	}
	
	@Override
	public long getDataCount(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return dataInfoMapper.getDataCount(tableName);
	}

	@Override
	public String findWheatherTableExist(String tableName) throws Exception {
		// TODO Auto-generated method stub
		return dataInfoMapper.findWheatherTableExist(tableName);
	}
	
}
