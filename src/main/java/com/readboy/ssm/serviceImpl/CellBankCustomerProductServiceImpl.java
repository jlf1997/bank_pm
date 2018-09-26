package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CellBankCustomerProductMapper;
import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.CellBankCustomerProductService;

public class CellBankCustomerProductServiceImpl implements CellBankCustomerProductService{

	@Autowired
	private CellBankCustomerProductMapper cellBankCustomerProductMapper;
	
	@Override
	public List<CellBankCustomerProduct> findCellBankProductsByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return cellBankCustomerProductMapper.findCellBankProductsByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public CellBankCustomerProduct findOneCellBankProductsByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return cellBankCustomerProductMapper.findOneCellBankProductsByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm)
			throws Exception {
		// TODO Auto-generated method stub
		return cellBankCustomerProductMapper.findDataCountByCond(khbh, jgdm);
	}

}
