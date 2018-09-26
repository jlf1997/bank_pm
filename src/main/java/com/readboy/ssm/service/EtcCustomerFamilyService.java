package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.EtcCustomerFamily;
import com.readboy.ssm.po.PageOption;

public interface EtcCustomerFamilyService {
	
	public List<EtcCustomerFamily> findEtcCustomerFamilysByKhbhAndJgdm(String khbh, String jgdm) throws Exception;
	
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception;

	public EtcCustomerFamily findOneEtcCustomerFamilysByKhbhAndJgdm(String khbh, String jgdm) throws Exception;

}
