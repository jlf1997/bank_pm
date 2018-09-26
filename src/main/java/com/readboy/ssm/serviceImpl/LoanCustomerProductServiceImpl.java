package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.LoanCustomerProductMapper;
import com.readboy.ssm.po.LoanCustomerProduct;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.LoanCustomerProductService;

public class LoanCustomerProductServiceImpl implements LoanCustomerProductService{

	@Autowired
	private LoanCustomerProductMapper loanCustomerProductMapper;
	
	@Override
	public List<LoanCustomerProduct> findLoanProductsByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.findLoanProductsByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public List<String> findLoanProductsHthByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.findLoanProductsHthByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public LoanCustomerProduct findLoanProductsByHth(String khbh,
			String jgdm, String hth) throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.findLoanProductsByHth(khbh, jgdm, hth);
	}

	@Override
	public LoanCustomerProduct findOneLoanProductsByKhbhAndJgdm(String khbh,
			String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.findOneLoanProductsByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public long batchInsertLoanCustomerProduct(List<LoanCustomerProduct> list)
			throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.batchInsertLoanCustomerProduct(list);
	}

	@Override
	public long insertLoanCustomerProduct(LoanCustomerProduct product)
			throws Exception {
		// TODO Auto-generated method stub
		return loanCustomerProductMapper.insertLoanCustomerProduct(product);
	}

	@Override
	public Integer findLoanProCount(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		
		Integer num =  loanCustomerProductMapper.findLoanProCount(khbh, jgdm);
		return num!= null ? num : 0;
	}

	@Override
	public Integer findHthCount(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		Integer num = loanCustomerProductMapper.findHthCount(khbh, jgdm);
		return num != null ? num : 0;
	}

}
