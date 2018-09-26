package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceJgReductionMx;
import com.readboy.ssm.po.PerformanceMx;

public interface PerformanceJgReductionMxService {
		
	public List<PerformanceJgReductionMx> findPerformanceJgReductionMx(String yggh,
			 String gzrq,String zbid) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			 String gzrq,String zbid) throws Exception;
}
