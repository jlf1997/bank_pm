package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CustomerMapper;
import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerMapper customerMapper;
	@Override
	public List<Customer> findAllCustomerByKhlx(int khlx, String gyh,String condition,PageOption page)
			throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.findAllCustomerByKhlx(khlx, gyh,condition,page);
	}
	
	@Override
	public Customer findCustomerByKhbhAndGhrgh(String khbh, String ghrgh,String condition)
			throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerByKhbhAndGhrgh(khbh, ghrgh,condition);
	}

	@Override
	public long batchInsertCustomer(List<Customer> list) throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.batchInsertCustomer(list);
	}

	@Override
	public Integer findDataCountByCond(int khlx, String gyh, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.findDataCountByCond(khlx, gyh, condition);
	}
	
}
