package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.LoanCustomerPersonMapper;
import com.readboy.ssm.po.LoanCustomerPerson;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.LoanCustomerPersonService;

public class LoanCustomerPersonServiceImpl implements LoanCustomerPersonService{

	@Autowired
	private LoanCustomerPersonMapper LoanCustomerPersonMapper;
	
	@Override
	public List<LoanCustomerPerson> findLoanPersonsByKhbhAndJgdm(
			String khbh, String jgdm, String hth) throws Exception {
		// TODO Auto-generated method stub
		return LoanCustomerPersonMapper.findLoanPersonsByKhbhAndJgdm(khbh, jgdm, hth);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm, String hth)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = LoanCustomerPersonMapper.findDataCountByCond(khbh, jgdm, hth);
		return num != null ? num : 0;
	}

}
