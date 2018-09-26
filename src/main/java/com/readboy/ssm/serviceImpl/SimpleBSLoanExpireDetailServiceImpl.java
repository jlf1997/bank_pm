package com.readboy.ssm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleBSLoanExpireDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanExpireDetail;
import com.readboy.ssm.service.SimpleBSLoanExpireDetailService;

public class SimpleBSLoanExpireDetailServiceImpl implements SimpleBSLoanExpireDetailService{

	@Autowired
	SimpleBSLoanExpireDetailMapper simpleBSLoanExpireDetailMapper;
	
	@Override
	public List<SimpleBSLoanExpireDetail> findSimpleBSLoanExpireDetail(
			String bsrgh, String ksrq, String dqrq) throws Exception {
		// TODO Auto-generated method stub
		List<SimpleBSLoanExpireDetail> list = new ArrayList<SimpleBSLoanExpireDetail>();
		list = simpleBSLoanExpireDetailMapper.findSimpleBSLoanExpireDetail(bsrgh, ksrq, dqrq);
		return list;
	}

	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String dqrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSLoanExpireDetailMapper.findDataCountByCond(bsrgh, ksrq, dqrq);
		return num != null ? num : 0;
	}
	
}
