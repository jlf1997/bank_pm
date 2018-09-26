package com.readboy.ssm.service;

import java.util.List;


import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.StaffJj;
import com.readboy.ssm.po.StaffJjCustom;


public interface StaffJjService {
	//查询本系统所在地区
	public List<StaffJj> findStaffJjbyCond(String yggh, String jjrq, String jjgw, PageOption page) throws Exception;
	
	public StaffJjCustom findStaffJjCustom(String zzbz,String yggh) throws Exception;
	
	/**
	 * 插入柜员交接条目
	 * @param staffJj
	 * @return
	 * @throws Exception
	 */
	public Integer insertStaffJj(StaffJj staffJj) throws Exception;
}
