package com.readboy.ssm.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CellBankCustomerPersonMapper;
import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.CellBankCustomerPersonService;

public class CellBankCustomerPersonServiceImpl implements CellBankCustomerPersonService{

	@Autowired
	private CellBankCustomerPersonMapper cellBankCustomerPersonMapper;
	
	@Override
	public List<CellBankCustomerPerson> findCellBankPersonsByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return cellBankCustomerPersonMapper.findCellBankPersonsByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		Integer num = cellBankCustomerPersonMapper.findDataCountByCond(khbh, jgdm);
		return num != null ? num :0;
	}

}
