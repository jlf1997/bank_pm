package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.LoanMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceBusinessDetail;
import com.readboy.ssm.po.PerformanceJymb;
/*
 * 工资_业务量明细
 * */
public interface PerformanceJymbMapper {
	
	public PerformanceJymb findPerformanceJymb(
			@Param("yggh")String yggh,
			@Param("gzrq")String gzrq,@Param("zbid")String zbid) throws Exception;
	
}
