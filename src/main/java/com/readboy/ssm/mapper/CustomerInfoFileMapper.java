package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CustomerInfoFile;
/*
 *
 * */
public interface CustomerInfoFileMapper {
	
 	//插入一条数据
	public int insertCustomerInfoFile(CustomerInfoFile customerInfoFile) throws Exception;
	
	//删除一条记录
	public int deleteCustomerInfoFile(
			@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh,
			@Param("file_type") String file_type,
			@Param("file_name") String file_name) throws Exception;
	
	//更新一条记录
	public void updateCustomerInfoFile(CustomerInfoFile CustomerInfoFile) throws Exception;
	
	//获取一条
	public CustomerInfoFile findCustomerInfoFile(
			@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh,
			@Param("file_type") String file_type,
			@Param("file_name") String file_name) throws Exception;
		
	//获取全部	
	public List<CustomerInfoFile> findAllCustomerInfoFile(
			@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh) throws Exception;
	
	public List<CustomerInfoFile> findDistinctCustomer(@Param("ghrgh") String ghrgh,
			@Param("condition")String condition) throws Exception;
	
	public List<CustomerInfoFile> findCustomerPicAndVedio(@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh) throws Exception;
	
	public CustomerInfoFile findOneCustomerPicAndVedio(@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh,@Param("file_name") String file_name,
			@Param("file_type") String file_type) throws Exception;
	
}
