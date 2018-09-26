package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankTradeMx;
/*
 * 管理绩效明细
 * */
public interface PerformanceCellBankTradeMxMapper {
	
	public List<PerformanceCellBankTradeMx> findPerformanceCellBankTradeMx(
			@Param("yggh") String yggh,@Param("stt") String stt,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition
			,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("stt") String stt,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
}
