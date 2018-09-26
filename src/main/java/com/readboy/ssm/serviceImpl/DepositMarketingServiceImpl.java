package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.DepositMarketingMapper;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.DepositMarketingService;

public class DepositMarketingServiceImpl implements DepositMarketingService{
	
	@Autowired
	private DepositMarketingMapper depositeMarketingMapper;
	
	@Override
	public DepositMarketing findDepositMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		DepositMarketing depositeMarketing = depositeMarketingMapper.findDepositMarketingByYybh(yybh);
		return depositeMarketing;
	}

	@Override
	public void updateDepositMarketing(DepositMarketing depositMarketing) throws Exception{
		// TODO Auto-generated method stub
		depositeMarketingMapper.updateDepositMarketing(depositMarketing);
	}

	@Override
	public long insertDepositMarketing(DepositMarketing depositMarketing)
			throws Exception {
		// TODO Auto-generated method stub
		long yybh = depositeMarketingMapper.insertDepositMarketing(depositMarketing);
		return yybh;
	}

	@Override
	public long deleteOneDepositMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		return depositeMarketingMapper.deleteOneDepositMarketingByYybh(yybh);
	}

	@Override
	public List<DepositMarketing> findDepositMarketingByYggh(String yggh,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return depositeMarketingMapper.findDepositMarketingByYggh(yggh, condition,page);
	}

	@Override
	public List<DepositMarketing> findAllDepositMarketing() throws Exception {
		// TODO Auto-generated method stub
		return depositeMarketingMapper.findAllDepositMarketing();
	}

	@Override
	public List<DepositMarketing> findDepositMarketingByPrefix(String prefix, int len)
			throws Exception {
		// TODO Auto-generated method stub
		return depositeMarketingMapper.findDepositMarketingByPrefix(prefix, len);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		Integer count = depositeMarketingMapper.findDataCountByCond(yggh, condition);
		if(count == null)
			return 0;
		return count;
	}

	@Override
	public DepositMarketing findDepoditMarketingExits(String jgdm, String zjhm, String yyrq) throws Exception {
		// TODO Auto-generated method stub
		return depositeMarketingMapper.findDepoditMarketingExits(jgdm, zjhm, yyrq);
	}
	
}
