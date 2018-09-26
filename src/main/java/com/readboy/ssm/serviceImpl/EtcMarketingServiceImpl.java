package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.EtcMarketingMapper;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.EtcMarketingService;

public class EtcMarketingServiceImpl implements EtcMarketingService{
	
	@Autowired
	private EtcMarketingMapper etcMarketingMapper;
	@Override
	public EtcMarketing findEtcMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		EtcMarketing etceMarketing = etcMarketingMapper.findEtcMarketingByYybh(yybh);
		return etceMarketing;
	}
	
	@Override
	public List<EtcMarketing> findAllEtcMarketing() throws Exception{
		// TODO Auto-generated method stub
		return etcMarketingMapper.findAllEtcMarketing();
	}
	
	@Override
	public void updateEtcMarketing(EtcMarketing etcMarketing) throws Exception{
		// TODO Auto-generated method stub
		etcMarketingMapper.updateEtcMarketing(etcMarketing);
	}

	@Override
	public long insertEtcMarketing(EtcMarketing etcMarketing)
			throws Exception {
		// TODO Auto-generated method stub
		long yybh = etcMarketingMapper.insertEtcMarketing(etcMarketing);
		return yybh;
	}

	@Override
	public long deleteOneEtcMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		return etcMarketingMapper.deleteOneEtcMarketingByYybh(yybh);
	}

	@Override
	public List<EtcMarketing> findEtcMarketingByYggh(String yggh,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return etcMarketingMapper.findEtcMarketingByYggh(yggh, condition,page);
	}

	@Override
	public List<EtcMarketing> findEtcMarketingByPrefix(String prefix, int len)
			throws Exception {
		// TODO Auto-generated method stub
		return etcMarketingMapper.findEtcMarketingByPrefix(prefix, len);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		Integer count = etcMarketingMapper.findDataCountByCond(yggh, condition);
		if(count == null)
			return 0;
		return count;
	}

	@Override
	public EtcMarketing findEtcMarketingExits(String jgdm, String zjhm, String yyrq) throws Exception {
		// TODO Auto-generated method stub
		return etcMarketingMapper.findEtcMarketingExits(jgdm, zjhm, yyrq);
	}
	
}
