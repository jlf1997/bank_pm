package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.LoanMarketingMapper;
import com.readboy.ssm.po.LoanMarketing;
import com.readboy.ssm.service.LoanMarketingService;

public class LoanMarketingServiceImpl implements LoanMarketingService{
	
	@Autowired
	private LoanMarketingMapper loaneMarketingMapper;
	@Override
	public LoanMarketing findLoanMarketingByYybh(int yybh) throws Exception {
		// TODO Auto-generated method stub
		LoanMarketing LoaneMarketing = loaneMarketingMapper.findLoanMarketingByYybh(yybh);
		return LoaneMarketing;
	}
	
	@Override
	public List<LoanMarketing> findAllLoanMarketing() throws Exception{
		// TODO Auto-generated method stub
		return loaneMarketingMapper.findAllLoanMarketing();
	}
	
	@Override
	public void updateLoanMarketing(LoanMarketing loanMarketing) throws Exception{
		// TODO Auto-generated method stub
		loaneMarketingMapper.updateLoanMarketing(loanMarketing);
	}

	@Override
	public int insertLoanMarketing(LoanMarketing loanMarketing)
			throws Exception {
		// TODO Auto-generated method stub
		int yybh = loaneMarketingMapper.insertLoanMarketing(loanMarketing);
		return yybh;
	}

	@Override
	public void deleteOneLoanMarketingByYybh(int yybh) throws Exception {
		// TODO Auto-generated method stub
		loaneMarketingMapper.deleteOneLoanMarketingByYybh(yybh);
	}
	
}
