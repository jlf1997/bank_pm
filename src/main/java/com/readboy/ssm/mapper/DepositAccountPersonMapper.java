package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.po.PageOption;

public interface DepositAccountPersonMapper {

	//根据客户编号和机构查询存款管户人
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

	//根据客户编号查询存款管户人
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbh(
			String khbh) throws Exception;
	
	public int findDataCountByKhbh(
			@Param("khbh") String khbh) throws Exception;
}
