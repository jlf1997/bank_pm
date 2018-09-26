package com.readboy.ssm.mapper;

import com.readboy.ssm.po.Area;

/**
 * 地区Mapper
 * @author:	   	LCL
 * @date: 	   	2017-10-17
 * @description:
 */
public interface AreaMapper {
	
	//查询本系统所在地区
	public Area findArea() throws Exception;
}
