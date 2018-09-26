package com.readboy.ssm.service;

import com.readboy.ssm.po.SimpleCustomerInfo;

public interface SimpleCustomerInfoService {
	
	public SimpleCustomerInfo findSimpleCustomerInfo(String khbh) throws Exception;
	
	public int findDepositNote (String khbh) throws Exception;
	
	public int findLoanNote (String khbh) throws Exception;
	
	public int findCellBankNote (String khbh) throws Exception;
	
	public int findEtcNote (String khbh) throws Exception;
}
