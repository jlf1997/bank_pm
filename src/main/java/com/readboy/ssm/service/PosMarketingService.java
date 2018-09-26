package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PosMarketing;

public interface PosMarketingService{
	
	//删除一条存款营销登记记录
	public long deleteOnePosMarketingByYybh(long yybh) throws Exception;
	
	//获取一条存款营销登记记录
	public PosMarketing findPosMarketingByYybh(long yybh) throws Exception;
	
	//条件查询存款营销登记
	public List<PosMarketing> findPosMarketingByYggh(String yggh,String condition,PageOption page) throws Exception;
	
	public Integer findDataCountByCond (String yggh,String condition) throws Exception;
	
	public List<PosMarketing> findAllPosMarketing() throws Exception;
	
	//更新存款营销登记记录
	public void updatePosMarketing(PosMarketing posMarketing) throws Exception;
	
	//插入数据
	public long insertPosMarketing(PosMarketing posMarketing) throws Exception;
	
	//查询手机或PC端新增的存款营销记录，len是长度
	public List<PosMarketing> findPosMarketingByPrefix(String prefix,int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public PosMarketing findPosMarketingExits(String jgdm ,String zjhm ,String yyrq) throws Exception;
}
