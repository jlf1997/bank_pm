package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.PageOption;

public interface DepositMarketingService {
	
	//删除一条存款营销登记记录
	public long deleteOneDepositMarketingByYybh(long yybh) throws Exception;
	
	//获取一条存款营销登记记录
	public DepositMarketing findDepositMarketingByYybh(long yybh) throws Exception;
	
	//条件查询存款营销登记
	public List<DepositMarketing> findDepositMarketingByYggh(String yggh,
			String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,String condition) throws Exception;
	
	//查询所有存款营销登记表
	public List<DepositMarketing> findAllDepositMarketing() throws Exception;
	
	//更新存款营销登记记录
	public void updateDepositMarketing(DepositMarketing depositMarketing) throws Exception;
	
	//插入数据
	public long insertDepositMarketing(DepositMarketing depositMarketing) throws Exception;
	
	//查询手机或PC端新增的存款营销记录，len是长度
	public List<DepositMarketing> findDepositMarketingByPrefix(String prefix,int len) throws Exception;
	
	public DepositMarketing findDepoditMarketingExits(String jgdm,String zjhm,String yyrq) throws Exception;
	
	public DepositMarketing findDepoditMarketingExitsForNewVersion(String jgdm,String khmc,String zjhm,String yyrq) throws Exception;
	
	
}
