package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.LoanCustomerPerson;
import com.readboy.ssm.po.PageOption;

public interface LoanCustomerPersonService {
	
	public List<LoanCustomerPerson> findLoanPersonsByKhbhAndJgdm(String khbh, String jgdm, 
			String hth) throws Exception;
	
	public Integer findDataCountByCond(String khbh, String jgdm, String hth) throws Exception;

}
