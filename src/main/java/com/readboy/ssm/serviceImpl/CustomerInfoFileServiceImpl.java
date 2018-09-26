package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CustomerInfoFileMapper;
import com.readboy.ssm.po.CustomerInfoFile;
import com.readboy.ssm.service.CustomerInfoFileService;

public class CustomerInfoFileServiceImpl implements CustomerInfoFileService{

	@Autowired
	private CustomerInfoFileMapper customerInfoFileMapper;
	
	@Override
	public void deleteOneCustomerInfoFile(String khbh, String ghrgh,
			String file_name, String file_type) throws Exception {
		// TODO Auto-generated method stub
		customerInfoFileMapper.deleteCustomerInfoFile(khbh, ghrgh, file_type, file_name);
	}

	@Override
	public CustomerInfoFile findCustomerInfoFile(String khbh, String ghrgh,
			String file_name, String file_type) throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.findCustomerInfoFile(khbh, ghrgh, file_type, file_name);
	}

	@Override
	public List<CustomerInfoFile> findAllCustomerInfoFile(String khbh,
			String ghrgh) throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.findAllCustomerInfoFile(khbh, ghrgh);
	}

	@Override
	public void updateCustomerInfoFile(CustomerInfoFile customerInfoFile)
			throws Exception {
		// TODO Auto-generated method stub
		customerInfoFileMapper.updateCustomerInfoFile(customerInfoFile);
	}

	@Override
	public int insertCustomerInfoFile(CustomerInfoFile customerInfoFile)
			throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.insertCustomerInfoFile(customerInfoFile);
	}

	@Override
	public List<CustomerInfoFile> findDistinctCustomer(String grhgh,
			String condition) throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.findDistinctCustomer(grhgh, condition);
	}

	@Override
	public List<CustomerInfoFile> findCustomerPicAndVedio(String khbh,
			String ghrgh) throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.findCustomerPicAndVedio(khbh, ghrgh);
	}

	@Override
	public CustomerInfoFile findOneCustomerPicAndVedio(String khbh,
			String ghrgh, String file_name, String file_type) throws Exception {
		// TODO Auto-generated method stub
		return customerInfoFileMapper.findOneCustomerPicAndVedio(khbh, ghrgh, file_name, file_type);
	}

}
