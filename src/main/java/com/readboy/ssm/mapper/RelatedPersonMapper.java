package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.RelatedPerson;

public interface RelatedPersonMapper {
	
	//根据客户编号和机构代码查找关联人信息
	public List<RelatedPerson> findRelatedPersonByKhbhAndJgdm(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khbh") String khbh,
			@Param("jgdm") String jgdm) throws Exception;

}
