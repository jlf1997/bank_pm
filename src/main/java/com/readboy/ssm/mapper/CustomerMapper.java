package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.PageOption;
public interface CustomerMapper {

	//查询所有APP_客户
	public List<Customer> findAllCustomerByKhlx(
			@Param("khlx") int khlx,
			@Param("gyh") String gyh,@Param("condition") String condition,
			@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("khlx") int khlx,
			@Param("gyh") String gyh,@Param("condition") String condition) throws Exception;

	//根据客户编号查找客户信息
	public Customer findCustomerByKhbhAndGhrgh(
			@Param("khbh") String khbh,
			@Param("ghrgh") String ghrgh,@Param("condition") String condition) throws Exception;

	public long batchInsertCustomer(@Param("list") List<Customer> list)throws Exception;
}
