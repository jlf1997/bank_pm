package com.readboy.ssm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.appjx.dto.MyInfo;
import com.readboy.ssm.po.StaffAndPost;

public interface StaffAndPostMapper {
	
	//根据组织标志查询柜员号
	public String findYgghByZzbz(
			@Param("zzbz") String zzbz,@Param("rglx")int rglx) throws Exception;
	
	
	public StaffAndPost findStaffAndPostByYggh(
			@Param("yggh") String yggh) throws Exception;
	
	public StaffAndPost findStaffAndPostByYgghAndTjrq(
			@Param("yggh") String yggh,
			@Param("fd") Date fd,
			@Param("ed") Date ed
			) throws Exception;
	
	
	public List<MyInfo> findStaffAndPostsByYggh (
			@Param("yggh") String yggh) throws Exception;
	
	public MyInfo findStaffAndPostsByYgghNow(
			@Param("yggh") String yggh) throws Exception;
}
