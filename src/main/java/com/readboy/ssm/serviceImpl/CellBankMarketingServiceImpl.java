package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.CellBankMarketingMapper;
import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.CellBankMarketingService;

public class CellBankMarketingServiceImpl implements CellBankMarketingService{
	
	@Autowired
	private CellBankMarketingMapper cellBankeMarketingMapper;
	@Override
	public CellBankMarketing findCellBankMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		CellBankMarketing cellBankeMarketing = cellBankeMarketingMapper.findCellBankMarketingByYybh(yybh);
		return cellBankeMarketing;
	}
	
	@Override
	public List<CellBankMarketing> findAllCellBankMarketing() throws Exception{
		// TODO Auto-generated method stub
		return cellBankeMarketingMapper.findAllCellBankMarketing();
	}
	
	@Override
	public void updateCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception{
		// TODO Auto-generated method stub
		cellBankeMarketingMapper.updateCellBankMarketing(cellBankMarketing);
	}

	@Override
	public long insertCellBankMarketing(CellBankMarketing cellBankMarketing)
			throws Exception {
		// TODO Auto-generated method stub
		long yybh = cellBankeMarketingMapper.insertCellBankMarketing(cellBankMarketing);
		return yybh;
	}

	@Override
	public long deleteOneCellBankMarketingByYybh(long yybh) throws Exception {
		// TODO Auto-generated method stub
		return cellBankeMarketingMapper.deleteOneCellBankMarketingByYybh(yybh);
	}

	@Override
	public List<CellBankMarketing> findCellBankMarketingByYggh(String yggh,
			String condition,PageOption page) throws Exception {
		// TODO Auto-generated method stub
		return cellBankeMarketingMapper.findCellBankMarketingByYggh(yggh, condition,page);
	}

	@Override
	public List<CellBankMarketing> findCellBankMarketingByPrefix(String prefix,int len)
			throws Exception {
		// TODO Auto-generated method stub
		return cellBankeMarketingMapper.findCellBankMarketingByPrefix(prefix,len);
	}

	@Override
	public Integer findDataCountByCond(String yggh, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		Integer count = cellBankeMarketingMapper.findDataCountByCond(yggh, condition);
		if(count == null)
			return 0;
		return count;
	}

	@Override
	public CellBankMarketing findCellBankMarketingExits(String jgdm, String zjhm, String yyrq) throws Exception {
		// TODO Auto-generated method stub
		return cellBankeMarketingMapper.findCellBankMarketingExits(jgdm, zjhm, yyrq);
	}
	
}
