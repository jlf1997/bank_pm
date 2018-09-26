package com.readboy.ssm.service;

import java.util.List;
import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.PageOption;

public interface DepositAccountFamilyService {
	
	
	public List<DepositAccountFamily> findAllDepositAccountFamilyByKhbhAndJgdm(String khbh
			, String jgdm) throws Exception;
	
	public Integer findDataCountByCond (String khbh , String jgdm) throws Exception;

	public DepositAccountFamily findOneDepositAccountFamilyByKhbhAndJgdm(String khbh, String jgdm) throws Exception;

	
}
