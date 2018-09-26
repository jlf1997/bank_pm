package com.readboy.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleCustomerInfoMapper;
import com.readboy.ssm.po.SimpleCustomerInfo;
import com.readboy.ssm.service.SimpleCustomerInfoService;

public class SimpleCustomerInfoServiceImpl implements SimpleCustomerInfoService{
	@Autowired
	private SimpleCustomerInfoMapper simpleCustomerInfoMapper;
	@Override
	public SimpleCustomerInfo findSimpleCustomerInfo(String khbh)
			throws Exception {
		// TODO Auto-generated method stub
		return simpleCustomerInfoMapper.findSimpleCustomerInfo(khbh);
	}

	@Override
	public int findDepositNote(String khbh) throws Exception {
		// TODO Auto-generated method stub
		return simpleCustomerInfoMapper.findDepositNote(khbh);
	}

	@Override
	public int findLoanNote(String khbh) throws Exception {
		// TODO Auto-generated method stub
		return simpleCustomerInfoMapper.findLoanNote(khbh);
	}

	@Override
	public int findCellBankNote(String khbh) throws Exception {
		// TODO Auto-generated method stub
		return simpleCustomerInfoMapper.findCellBankNote(khbh);
	}

	@Override
	public int findEtcNote(String khbh) throws Exception {
		// TODO Auto-generated method stub
		return simpleCustomerInfoMapper.findEtcNote(khbh);
	}
	
	
}
