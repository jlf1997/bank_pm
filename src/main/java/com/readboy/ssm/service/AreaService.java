package com.readboy.ssm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.readboy.ssm.po.Area;
import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.PageOption;

public interface AreaService {
	//查询本系统所在地区
	public Area findArea() throws Exception;

}
