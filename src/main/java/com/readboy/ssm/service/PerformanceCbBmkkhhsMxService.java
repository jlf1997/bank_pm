package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCbBmkkhhsMx;

public interface PerformanceCbBmkkhhsMxService {
	
	public List<PerformanceCbBmkkhhsMx> findPerformanceCbBmkkhhsMx(
			String ksrq,String jsrq,String yggh,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			String ksrq,String jsrq,String yggh,String condition) throws Exception;
}
