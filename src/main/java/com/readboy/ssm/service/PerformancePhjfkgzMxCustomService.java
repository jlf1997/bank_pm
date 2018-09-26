package com.readboy.ssm.service;


import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformancePhjfkgzMxCustom;

public interface PerformancePhjfkgzMxCustomService {
		
	public List<PerformancePhjfkgzMxCustom> findPerformancePhjfkgzMxCustom(
			String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
	
	public Integer findDataCountByCond(String yggh,String zzbz,String gwbz,
			String ksrq,String jsrq)throws Exception;
	
}
