package com.readboy.ssm.service;

import java.util.List;


import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgpjMx;

public interface PerformanceJgpjMxService {
		
	public List<PerformanceJgpjMx> findPerformanceJgpjMx(String yggh,
			 String gzrq,String zbid) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			 String gzrq,String zbid) throws Exception;
}
