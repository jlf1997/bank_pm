package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceDkkhbsMx;
/*
 * 贷款客户包收明细
 * */
public interface PerformanceDkkhbsMxMapper {
	
	public List<PerformanceDkkhbsMx> findPerformanceDkkhbsMx(
			@Param("yggh") String yggh,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
}
