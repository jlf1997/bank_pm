package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSNewAddBadLoanDetail;
import com.readboy.ssm.po.SimpleBSOverdueLoanDetail;

/*
 * 包收逾期贷款明细Mapper
 * */
public interface SimpleBSOverdueLoanDetailMapper {
	
	public List<SimpleBSOverdueLoanDetail> findSimpleBSOverdueLoanDetail(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
}
