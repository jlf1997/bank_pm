package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PerformanceMx;

public interface PerformanceMxService {
	
//	public List<Performance> findAllPerformance(int khlx, String gyh) throws Exception;
	
	public List<PerformanceMx> findPerformanceMx(String yggh, String gzrq, int zblb) throws Exception;
	
}
