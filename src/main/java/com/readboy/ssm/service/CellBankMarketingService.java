package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.PageOption;

public interface CellBankMarketingService {
	
	//删除一条手机银行营销登记记录
	public long deleteOneCellBankMarketingByYybh(long yybh) throws Exception;
	//获取一条手机银行营销登记记录
	public CellBankMarketing findCellBankMarketingByYybh(long yybh) throws Exception;
	
	//获取所有手机银行营销登记
	public List<CellBankMarketing> findAllCellBankMarketing() throws Exception;
	
	//获取所有手机银行营销登记
	public List<CellBankMarketing> findCellBankMarketingByYggh(String yggh,
			String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,
			String condition) throws Exception;
	
	//更新手机银行营销登记记录
	public void updateCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception;
	
	//插入数据
	public long insertCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception;
	
	//查找手机银行插入的数据
	public List<CellBankMarketing> findCellBankMarketingByPrefix(String prefix,int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public CellBankMarketing findCellBankMarketingExits(String jgdm , String zjhm , String yyrq) throws Exception;
}
