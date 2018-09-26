package com.readboy.ssm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.StaffJjCustom;

/**
 * 柜员交接自定义查询
 * @author:	   	LCL
 * @date: 	   	2017-10-17
 * @description:
 */
public interface StaffJjCustomMapper {
	
	public StaffJjCustom findStaffJjCustom(@Param("zzbz") String zzbz,
			@Param("yggh") String yggh,@Param("firstDayOfMonth") String firstDayOfMonth,
			@Param("lastDayOfMonth") String lastDayOfMonth) throws Exception;
}
