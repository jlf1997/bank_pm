package com.readboy.ssm.service;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkDndqdkshl;

public interface PerformanceDkDndqdkshlService {
	
	public PerformanceDkDndqdkshl findPerformanceDkDndqdkshl(
			String ksrq,String jsrq,String yggh,String zbid) throws Exception;
	
	public Integer findDataCountByCond(
			String ksrq,String jsrq,String yggh,String zbid) throws Exception;
	
}
