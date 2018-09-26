package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.PageOption;
/*
 * 持有产品，手机银行产品
 * */
public interface CellBankCustomerProductMapper {

	//根据客户编号查询手机银行
	public List<CellBankCustomerProduct> findCellBankProductsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

	//根据客户编号查询手机银行
	public CellBankCustomerProduct findOneCellBankProductsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;


}
