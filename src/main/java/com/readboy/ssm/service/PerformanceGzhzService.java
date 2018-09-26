package com.readboy.ssm.service;


import com.readboy.ssm.po.PerformanceGzhz;

public interface PerformanceGzhzService {
		
	public PerformanceGzhz findPerformanceGzhz(
			String yggh,String ksrq,String jsrq)throws Exception;
	
}
