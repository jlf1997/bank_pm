package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;

public interface EtcMarketingService {
	
	//删除一条存款营销登记记录
	public long deleteOneEtcMarketingByYybh(long yybh) throws Exception;
	
	//获取一条存款营销登记记录
	public EtcMarketing findEtcMarketingByYybh(long yybh) throws Exception;
	
	//获取所有存款营销登记
	public List<EtcMarketing> findAllEtcMarketing() throws Exception;
	
	//条件查询存款营销登记
	public List<EtcMarketing> findEtcMarketingByYggh(String yggh,String condition,
			PageOption page) throws Exception;
	
	public Integer findDataCountByCond(String yggh,String condition) throws Exception;
	
	//更新存款营销登记记录
	public void updateEtcMarketing(EtcMarketing etcMarketing) throws Exception;
	
	//插入数据
	public long insertEtcMarketing(EtcMarketing etcMarketing) throws Exception;
	
	//查询手机或PC端新增的存款营销记录，len是长度
	public List<EtcMarketing> findEtcMarketingByPrefix(String prefix,int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public EtcMarketing findEtcMarketingExits(String jgdm,String zjhm ,String yyrq) throws Exception;
}
