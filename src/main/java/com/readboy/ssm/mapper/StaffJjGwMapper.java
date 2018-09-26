package com.readboy.ssm.mapper;

import java.util.List;

import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.StaffJjGw;

public interface StaffJjGwMapper {
	
	public List<StaffJjGw> findStaffJjGw() throws Exception;

	/**
	 * 根据客户编号查询客户部门
	 * @param tellId		客户编号
	 * @return				组织信息
	 * @throws Exception
	 */
	public Organization findOrganization(String tellId) throws Exception;
	
}
