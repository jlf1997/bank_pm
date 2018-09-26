package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceCellBankHsMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankHsMx;
import com.readboy.ssm.service.PerformanceCellBankHsMxService;


public class PerformanceCellBankHsMxServiceImpl implements PerformanceCellBankHsMxService{
	
	@Autowired 
	private PerformanceCellBankHsMxMapper performanceCellBankHsMxMapper;

	@Override
	public List<PerformanceCellBankHsMx> findPerformanceCellBankHsMx(
			String yggh, int yxlx, String ksrq, String jsrq,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return performanceCellBankHsMxMapper.findPerformanceCellBankHsMx(yggh, yxlx, ksrq, jsrq,condition,page);
	}

	@Override
	public Integer findDataCountByCond(String yggh, int yxlx, String ksrq,
			String jsrq, String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = performanceCellBankHsMxMapper.findDataCountByCond(yggh, yxlx, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}

}
