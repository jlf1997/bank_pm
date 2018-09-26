package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDKDydklxshMx;

public interface PerformanceDkDydklxshMxService {
	
	public List<PerformanceDKDydklxshMx> findPerformanceDKDydklxshMx(
			String ksrq,String jsrq,String yggh,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			String ksrq,String jsrq,String yggh,String condition) throws Exception;
}
