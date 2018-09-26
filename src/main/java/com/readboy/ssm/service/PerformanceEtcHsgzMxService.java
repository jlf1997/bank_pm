package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceEtcHsgzMx;

public interface PerformanceEtcHsgzMxService {
		
	public List<PerformanceEtcHsgzMx> findPerformanceEtcHsgzMx(String yggh,
			int ghlx,String ksrq,String jsrq,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			int ghlx,String ksrq,String jsrq,String condition) throws Exception;
}
