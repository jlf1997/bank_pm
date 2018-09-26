package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.StaffInfo;

public interface StaffInfoMapper {
	public StaffInfo findStaffInfoByConditions(
			@Param("zzbz") String zzbz,@Param("gwbz")long gwbz,
			@Param("yggh") String yggh) throws Exception;
}
