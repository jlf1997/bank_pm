package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkkhbsMx;

public interface PerformanceDkkhbsMxService {
		
	public List<PerformanceDkkhbsMx> findPerformanceDkkhbsMx(String yggh,
			String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findDataCount(String yggh,String ksrq,String jsrq,String condition) throws Exception;
}
