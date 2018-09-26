package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkkhbsMx;
import com.readboy.ssm.po.PerformanceJymb;

public interface PerformanceJymbService {
		
	public PerformanceJymb findPerformanceJymb(String yggh,String gzrq, String zbid) throws Exception;
		
}	
