package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.DepositAccountPersonMapper;
import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.DepositAccountPersonService;

public class DepositAccountPersonServiceImpl implements DepositAccountPersonService{

	@Autowired
	private DepositAccountPersonMapper depositAccountPersonMapper;
	
	//存款管户人 这里不要分页
	@Override
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbhAndJgdm(
			String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		return depositAccountPersonMapper.findAllDepositAccountPersonByKhbhAndJgdm(khbh, jgdm);
	}

	@Override
	public List<DepositAccountPerson> findAllDepositAccountPersonByKhbh(
			String khbh) throws Exception {
		// TODO Auto-generated method stub
		return depositAccountPersonMapper.findAllDepositAccountPersonByKhbh(khbh);
	}

	@Override
	public Integer findDataCountByCond(String khbh, String jgdm) throws Exception {
		// TODO Auto-generated method stub
		Integer num = depositAccountPersonMapper.findDataCountByCond(khbh, jgdm);
		return num != null ? num:0;
	}

	@Override
	public Integer findDataCountByKhbh(String khbh) throws Exception {
		// TODO Auto-generated method stub
		Integer num = depositAccountPersonMapper.findDataCountByKhbh(khbh);
		return num != null ? num:0;
	}
	
	
	

}
