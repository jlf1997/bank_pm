package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.PerformanceCellBankTradeMxMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankTradeMx;
import com.readboy.ssm.service.PerformanceCellBankTradeMxService;


public class PerformanceCellBankTradeMxServiceImpl implements PerformanceCellBankTradeMxService{
	
	@Autowired 
	private PerformanceCellBankTradeMxMapper PerformanceCellBankTradeMxMapper;

	@Override
	public List<PerformanceCellBankTradeMx> findPerformanceCellBankTradeMx(
			String yggh, String stt, String ksrq, String jsrq,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return PerformanceCellBankTradeMxMapper.findPerformanceCellBankTradeMx(yggh, stt, ksrq, jsrq,condition,page);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String stt, String ksrq,
			String jsrq, String condition) throws Exception {
		// TODO Auto-generated method stub
		Integer num = PerformanceCellBankTradeMxMapper.findDataCountByCond(yggh, stt, ksrq, jsrq, condition);
		return num != null ? num : 0;
	}
}
