package com.readboy.ssm.service;


import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceAljcgzMx;
import com.readboy.ssm.po.PerformanceAljcgzMxCustom;

public interface PerformanceAljcgzMxCustomService{
		
	public List<PerformanceAljcgzMxCustom> findPerformanceAljcgzMxCustom(
			String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
	
	public Integer findDataCountByCond(
			String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
	
}
