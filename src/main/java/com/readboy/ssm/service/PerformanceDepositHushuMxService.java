package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDepositHushuMx;

public interface PerformanceDepositHushuMxService {
	
	public List<PerformanceDepositHushuMx> findPerformanceDepositHushuMx(String yggh,
			String tjrq,String lx,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,String tjrq,String lx,String condition) throws Exception;
}
