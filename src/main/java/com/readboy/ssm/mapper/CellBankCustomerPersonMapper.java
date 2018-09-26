package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.PageOption;
/*
 * 持有产品，手机银行管户
 * */
public interface CellBankCustomerPersonMapper {
	
	//根据客户编号查询手机银行管户
	public List<CellBankCustomerPerson> findCellBankPersonsByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
}
