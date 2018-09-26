package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankTradeMx;
import com.readboy.ssm.po.PerformanceEtcHsgzMx;

public interface PerformanceCellBankTradeMxService {
		
	public List<PerformanceCellBankTradeMx> findPerformanceCellBankTradeMx(String yggh,
			String stt,String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			String stt,String ksrq,String jsrq,String condition) throws Exception;
	
}
