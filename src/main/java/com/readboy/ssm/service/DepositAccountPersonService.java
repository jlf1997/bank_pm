package com.readboy.ssm.service;

import java.util.List;
import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.po.PageOption;

public interface DepositAccountPersonService {
	
	
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception;
	
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbh(String khbh) throws Exception;

	public Integer findDataCountByKhbh(String khbh) throws Exception;
}
