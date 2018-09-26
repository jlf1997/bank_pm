package com.readboy.ssm.mapper;

import com.readboy.ssm.po.SimpleCustomerInfo;

public interface SimpleCustomerInfoMapper {
	
	public SimpleCustomerInfo findSimpleCustomerInfo(String khbh) throws Exception;
	
	public int findDepositNote (String khbh) throws Exception;
	
	public int findLoanNote (String khbh) throws Exception;
	
	public int findCellBankNote (String khbh) throws Exception;
	
	public int findEtcNote (String khbh) throws Exception;
}
