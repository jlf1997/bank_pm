package com.readboy.ssm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.SimpleBSNewAddBadLoanDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSNewAddBadLoanDetail;
import com.readboy.ssm.service.SimpleBSNewAddBadLoanDetailService;

public class SimpleBSNewAddBadLoanDetailServiceImpl implements SimpleBSNewAddBadLoanDetailService{

	@Autowired
	SimpleBSNewAddBadLoanDetailMapper simpleBSNewAddBadLoanDetailMapper;
	
	@Override
	public List<SimpleBSNewAddBadLoanDetail> findSimpleBSNewAddBadLoanDetail(
			String bsrgh, String ksrq, String dqrq) throws Exception {
		// TODO Auto-generated method stub
		List list = new ArrayList<SimpleBSNewAddBadLoanDetail>();
		list = simpleBSNewAddBadLoanDetailMapper.findSimpleBSNewAddBadLoanDetail(bsrgh, ksrq, dqrq);
		return list;
	}

	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String dqrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSNewAddBadLoanDetailMapper.findDataCountByCond(bsrgh, ksrq, dqrq);
		return num != null ? num : 0;
	}
	
}
