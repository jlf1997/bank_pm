package com.readboy.ssm.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.readboy.ssm.mapper.SimpleBSOverdueLoanDetailMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSOverdueLoanDetail;
import com.readboy.ssm.service.SimpleBSOverdueLoanDetailService;

public class SimpleBSOverdueLoanDetailServiceImpl implements SimpleBSOverdueLoanDetailService{
	
	@Autowired
	private SimpleBSOverdueLoanDetailMapper simpleBSOverdueLoanDetailMapper;

	@Override
	public List<SimpleBSOverdueLoanDetail> findSimpleBSOverdueLoanDetail(
			String bsrgh, String ksrq, String dqrq) throws Exception {
		// TODO Auto-generated method stub
		return simpleBSOverdueLoanDetailMapper.findSimpleBSOverdueLoanDetail(bsrgh, ksrq, dqrq);
	}

	@Override
	public Integer findDataCountByCond(String bsrgh, String ksrq, String dqrq)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = simpleBSOverdueLoanDetailMapper.findDataCountByCond(bsrgh, ksrq, dqrq);
		return num != null ? num : 0;
	}
}
