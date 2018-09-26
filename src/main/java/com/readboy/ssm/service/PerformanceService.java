package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.Performance;

public interface PerformanceService {
	
//	public List<Performance> findAllPerformance(int khlx, String gyh) throws Exception;
	
	public Performance findPerformance(String yggh, String gzrq) throws Exception;
	
	public List<Performance> findAllPerformance() throws Exception;

}
