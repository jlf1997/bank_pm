package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.PosMarketingMapper;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PosMarketing;
import com.readboy.ssm.service.PosMarketingService;

public class PosMarketingServiceImpl implements PosMarketingService{
	
	@Autowired
	private PosMarketingMapper posMarketingMapper;
	@Override
	public PosMarketing findPosMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		PosMarketing poseMarketing = posMarketingMapper.findPosMarketingByYybh(yybh);
		return poseMarketing;
	}
	
	@Override
	public List<PosMarketing> findPosMarketingByYggh(String yggh,String condition,PageOption page) throws Exception{
		// TODO Auto-generated method stub
		return posMarketingMapper.findPosMarketingByYggh(yggh,condition,page);
	}
	
	@Override
	public void updatePosMarketing(PosMarketing posMarketing) throws Exception{
		// TODO Auto-generated method stub
		posMarketingMapper.updatePosMarketing(posMarketing);
	}

	@Override
	public long insertPosMarketing(PosMarketing posMarketing)
			throws Exception {
		// TODO Auto-generated method stub
		long yybh = posMarketingMapper.insertPosMarketing(posMarketing);
		return yybh;
	}

	@Override
	public long deleteOnePosMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		return posMarketingMapper.deleteOnePosMarketingByYybh(yybh);
	}

	@Override
	public List<PosMarketing> findAllPosMarketing() throws Exception {
		// TODO Auto-generated method stub
		return posMarketingMapper.findAllPosMarketing();
	}

	@Override
	public List<PosMarketing> findPosMarketingByPrefix(String prefix, int len)
			throws Exception {
		// TODO Auto-generated method stub
		return posMarketingMapper.findPosMarketingByPrefix(prefix, len);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		Integer count = posMarketingMapper.findDataCountByCond(yggh, condition);
		if(count == null)
			return 0;
		return count;
	}

	@Override
	public PosMarketing findPosMarketingExits(String jgdm, String zjhm, String yyrq) throws Exception {
		// TODO Auto-generated method stub
		return posMarketingMapper.findPosMarketingExits(jgdm, zjhm, yyrq);
	}
	
}
