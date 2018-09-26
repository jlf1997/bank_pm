package com.readboy.ssm.service;

import java.util.List;
import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.PageOption;

public interface CustomerService {
	
	public List<Customer> findAllCustomerByKhlx(int khlx, String gyh,String condition
			,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(int khlx, String gyh,String condition) throws Exception;
	
	//根据客户编号和管户人工号和模糊搜索条件查询客户
	public Customer findCustomerByKhbhAndGhrgh(String khbh, String ghrgh,
			String condition) throws Exception;
	
	//批量插入数据
	public long batchInsertCustomer(List<Customer> list)throws Exception;
}
