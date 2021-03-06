package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleBSLoanOweInterestDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanOweInterestDetail;
import com.readboy.ssm.service.SimpleBSLoanOweInterestDetailService;

public class SimpleBSLoanOweInterestDetailServiceImpl implements SimpleBSLoanOweInterestDetailService{
	
	@Autowired
	private SimpleBSLoanOweInterestDetailMapper simpleBSLoanOweInterestDetailMapper;
	@Override
	public List<SimpleBSLoanOweInterestDetail> findSimpleBSLoanOweInterestDetail(
			String bsrgh, String ksrq, String dqrq) throws Exception {
		// TODO Auto-generated method stub
		return simpleBSLoanOweInterestDetailMapper.findSimpleBSLoanOweInterestDetail(bsrgh, ksrq, dqrq);
	}
	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String dqrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSLoanOweInterestDetailMapper.findDataCountByCond(bsrgh, ksrq, dqrq);
		return num != null ? num : 0;
	}
}
