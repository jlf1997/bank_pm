package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.LoanCustomerPerson;
import com.readboy.ssm.po.PageOption;
/*
 * 持有产品，手机银行管户
 * */
public interface LoanCustomerPersonMapper {
	
	//根据客户编号查询手机银行管户
	public List<LoanCustomerPerson> findLoanPersonsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm,
			@Param("hth") String hth) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm,
			@Param("hth") String hth) throws Exception;
}
