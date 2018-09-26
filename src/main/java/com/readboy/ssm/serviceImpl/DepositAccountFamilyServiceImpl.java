package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.DepositAccountFamilyMapper;
import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.DepositAccountFamilyService;

public class DepositAccountFamilyServiceImpl implements DepositAccountFamilyService{
	
	@Autowired 
	DepositAccountFamilyMapper depositAccountFamilyMapper;

	@Override
	public List<DepositAccountFamily> findAllDepositAccountFamilyByKhbhAndJgdm(String khbh,
			String jgdm)
			throws Exception {
		// TODO Auto-generated method stub
		return depositAccountFamilyMapper.findAllDepositAccountFamilyByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public DepositAccountFamily findOneDepositAccountFamilyByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return depositAccountFamilyMapper.findOneDepositAccountFamilyByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return depositAccountFamilyMapper.findDataCountByCond(khbh, jgdm);
	}
	
	
}
