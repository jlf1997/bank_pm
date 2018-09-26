package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.LoanCustomerProduct;
import com.readboy.ssm.po.PageOption;
/*
 * 贷款客户产品信息
 * */
public interface LoanCustomerProductMapper {
	//根据客户编号
	public List<LoanCustomerProduct> findLoanProductsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findLoanProCount(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	//根据客户编号
	public LoanCustomerProduct findOneLoanProductsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

	public List<String> findLoanProductsHthByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findHthCount(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
//	public List<String> findLoanProductsHthByKhbhAndJgdm(
//			@Param("khbh") String khbh,
//			@Param("jgdm") String jgdm) throws Exception;
	
	public LoanCustomerProduct findLoanProductsByHth(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm,
			@Param("hth") String hth) throws Exception;
	
	//批量插入信息
	public long  batchInsertLoanCustomerProduct(List<LoanCustomerProduct> list) throws Exception;
	
	//插入一条记录
	public long  insertLoanCustomerProduct(LoanCustomerProduct product) throws Exception;
	

}
