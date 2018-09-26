package com.readboy.ssm.service;


import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceGxlgzMx;
import com.readboy.ssm.po.PerformanceGxlgzMxCustom;

public interface PerformanceGxlgzMxCustomService {
		
	public List<PerformanceGxlgzMxCustom> findPerformanceGxlgzMxCustom(
			String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
	
	public Integer findDataCountByCond(String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
}
