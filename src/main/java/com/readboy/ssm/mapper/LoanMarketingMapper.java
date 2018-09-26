package com.readboy.ssm.mapper;
import java.util.List;
import com.readboy.ssm.po.LoanMarketing;
/*
 * 存款营销登记记录操作Mapper
 * */
public interface LoanMarketingMapper {
	
 	//插入一条数据
	public int insertLoanMarketing(LoanMarketing loanMarketing) throws Exception;
	
	//删除一条记录
	public int deleteOneLoanMarketingByYybh(int yybh) throws Exception;
	
	//更新一条记录
	public void updateLoanMarketing(LoanMarketing loanMarketing) throws Exception;
	
	//获取一条存款营销登记记录
	public LoanMarketing findLoanMarketingByYybh(int yybh) throws Exception;
		
	//获取全部存款营销登记记录	
	public List<LoanMarketing> findAllLoanMarketing() throws Exception;
	
	
}
