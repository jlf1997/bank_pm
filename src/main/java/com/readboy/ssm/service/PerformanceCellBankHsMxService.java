package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankHsMx;

public interface PerformanceCellBankHsMxService {
		
	public List<PerformanceCellBankHsMx> findPerformanceCellBankHsMx(String yggh,
			int yxlx,String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,int yxlx,String ksrq,
			String jsrq,String condition) throws Exception;
	
	
}
