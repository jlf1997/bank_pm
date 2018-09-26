package com.readboy.ssm.service;

import java.util.List;
import com.readboy.ssm.po.DepositAccountFamily;

public interface DepositCustomerService {
	
	public List<DepositAccountFamily> findAllDepositCustomer(String khbh, String jgdm) throws Exception;
	
	

}
