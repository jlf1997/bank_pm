package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CustomerMultipleQueryMapper;
import com.readboy.ssm.po.CustomerMultipleQuery;
import com.readboy.ssm.service.CustomerMultipleQueryService;

public class CustomerMultipleQueryServiceImpl implements CustomerMultipleQueryService{
	
	@Autowired
	CustomerMultipleQueryMapper customerMultipleQueryMapper;
	@Override
	public CustomerMultipleQuery findCustomedCustomerInfo(String khbh) throws Exception {
		// TODO Auto-generated method stub
		return customerMultipleQueryMapper.findCustomedCustomerInfo(khbh);
	}
	
}
