package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CustomerInfoFile;

public interface CustomerInfoFileService {

	//删除一条
	public void deleteOneCustomerInfoFile(String khbh, String ghrgh, String file_name, String file_type) throws Exception;
	
	//获取一条
	public CustomerInfoFile findCustomerInfoFile(String khbh, String ghrgh, String file_name, String file_type) throws Exception;

	//获取所有
	public List<CustomerInfoFile> findAllCustomerInfoFile(String khbh, String ghrgh) throws Exception;

	//更新
	public void updateCustomerInfoFile(CustomerInfoFile customerInfoFile) throws Exception;

	//插入
	public int insertCustomerInfoFile(CustomerInfoFile customerInfoFile) throws Exception;
	
	//查询不同的客户
	public List<CustomerInfoFile> findDistinctCustomer(String grhgh,
			String condition) throws Exception;
	
	//查询某个客户的拜访信息
	public List<CustomerInfoFile> findCustomerPicAndVedio(String khbh,String ghrgh) throws Exception;
	
	//查询某个图片或视频
	public CustomerInfoFile findOneCustomerPicAndVedio( String khbh,
			String ghrgh,String file_name,String file_type) throws Exception;

}
