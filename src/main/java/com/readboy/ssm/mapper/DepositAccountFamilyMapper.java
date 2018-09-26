package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.PageOption;

public interface DepositAccountFamilyMapper {

	//根据客户编号和机构查询存款信息，一个客户对应多个存款账号
	public List<DepositAccountFamily> findAllDepositAccountFamilyByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

	//根据客户编号和机构查询存款信息，一个客户对应多个存款账号
	public DepositAccountFamily findOneDepositAccountFamilyByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

}
