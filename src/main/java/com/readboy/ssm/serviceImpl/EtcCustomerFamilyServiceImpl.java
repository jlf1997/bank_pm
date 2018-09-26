package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.EtcCustomerFamilyMapper;
import com.readboy.ssm.po.EtcCustomerFamily;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.EtcCustomerFamilyService;

public class EtcCustomerFamilyServiceImpl implements EtcCustomerFamilyService{

	@Autowired
	private EtcCustomerFamilyMapper EtcCustomerFamilyMapper;
	
	@Override
	public List<EtcCustomerFamily> findEtcCustomerFamilysByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return EtcCustomerFamilyMapper.findEtcCustomerFamilysByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public EtcCustomerFamily findOneEtcCustomerFamilysByKhbhAndJgdm(String khbh,
			String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return EtcCustomerFamilyMapper.findOneEtcCustomerFamilysByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		Integer num =  EtcCustomerFamilyMapper.findDataCountByCond(khbh, jgdm);
		return num != null ? num:0;
	}

}
