package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePersonalByCountMx;

public interface PerformancePersonalByCountMxService {
		
	public List<PerformancePersonalByCountMx> findPerformancePersonalByCountMx(String yggh,
			 String ksrq,String jsrq,String zbid) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			 String ksrq,String jsrq,String zbid) throws Exception;
}
