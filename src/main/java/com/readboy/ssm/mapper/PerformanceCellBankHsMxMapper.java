package com.readboy.ssm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PerformanceCellBankHsMx;
/*
 * 绩效_手机银行户数明细
 * */
public interface PerformanceCellBankHsMxMapper {
	
	public List<PerformanceCellBankHsMx> findPerformanceCellBankHsMx(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition
			,@Param("page") PageOption page) throws Exception;
	
	
	
	public Integer findDataCountByCond(
			@Param("yggh") String yggh,@Param("yxlx") int yxlx,
			@Param("ksrq") String ksrq,@Param("jsrq") String jsrq,
			@Param("condition") String condition) throws Exception;
}
