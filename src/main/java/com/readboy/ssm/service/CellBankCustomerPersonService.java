package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.PageOption;

public interface CellBankCustomerPersonService {
	
	public List<CellBankCustomerPerson> findCellBankPersonsByKhbhAndJgdm(String khbh, 
			String jgdm) throws Exception;
	
	public Integer findDataCountByCond(String khbh, 
			String jgdm) throws Exception;

}
