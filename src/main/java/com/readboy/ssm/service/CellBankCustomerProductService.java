package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.PageOption;

public interface CellBankCustomerProductService {
	
	public List<CellBankCustomerProduct> findCellBankProductsByKhbhAndJgdm(String khbh, 
			String jgdm) throws Exception;
	
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception;
	
	public CellBankCustomerProduct findOneCellBankProductsByKhbhAndJgdm(String khbh,
			String jgdm) throws Exception;
	
	
}
