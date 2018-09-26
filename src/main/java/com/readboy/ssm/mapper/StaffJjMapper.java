package com.readboy.ssm.mapper;

import java.util.List;

import com.readboy.ssm.po.PageOption;
import org.apache.ibatis.annotations.Param;
import com.readboy.ssm.po.StaffJj;

/**
 * 柜员交接
 * @author:	   	LCL
 * @date: 	   	2017-10-17
 * @description:
 */
public interface StaffJjMapper {
	
	public List<StaffJj> findStaffJjByCond(@Param("yggh") String yggh , @Param("jjrq") String jjrq,
										   @Param("jjgw") String jjgw, @Param("page")PageOption page) throws Exception;
	
	public Integer insertStaffJj(StaffJj staffJj) throws Exception;
}
