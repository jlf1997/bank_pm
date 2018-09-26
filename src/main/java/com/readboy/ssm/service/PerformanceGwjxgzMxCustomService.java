package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGwjxgzMxCustom;

public interface PerformanceGwjxgzMxCustomService {
		
	public List<PerformanceGwjxgzMxCustom> findPerformanceGwjxgzMxCustom(
			String yggh,String ksrq,String jsrq)throws Exception;
	
	public Integer findDataCountByCond(
			String yggh,String ksrq,String jsrq)throws Exception;
}
