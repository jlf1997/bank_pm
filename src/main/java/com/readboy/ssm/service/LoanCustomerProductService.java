package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.LoanCustomerProduct;
import com.readboy.ssm.po.PageOption;

public interface LoanCustomerProductService {
	
	public List<LoanCustomerProduct> findLoanProductsByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public Integer findLoanProCount(String khbh, String jgdm) throws Exception;
	
	public LoanCustomerProduct findOneLoanProductsByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public List<String> findLoanProductsHthByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public Integer findHthCount(String khbh, String jgdm) throws Exception;
	
	public LoanCustomerProduct findLoanProductsByHth(String khbh, String jgdm, String hth) throws Exception;
	
	public long batchInsertLoanCustomerProduct(List<LoanCustomerProduct> list) throws Exception;
	
	public long  insertLoanCustomerProduct(LoanCustomerProduct product) throws Exception;

}
