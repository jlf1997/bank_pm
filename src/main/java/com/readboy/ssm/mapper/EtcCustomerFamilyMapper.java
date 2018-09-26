package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.EtcCustomerFamily;
import com.readboy.ssm.po.PageOption;

public interface EtcCustomerFamilyMapper {

	//根据客户编号查询手机银行管户
	public List<EtcCustomerFamily> findEtcCustomerFamilysByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

	//根据客户编号查询手机银行管户
	public EtcCustomerFamily findOneEtcCustomerFamilysByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
}
