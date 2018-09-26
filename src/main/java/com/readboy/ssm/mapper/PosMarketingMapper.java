package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.PosMarketing;
/*
 * 存款营销登记记录操作Mapper
 * */
public interface PosMarketingMapper{
	
 	//插入一条数据
	public long insertPosMarketing(PosMarketing posMarketing) throws Exception;
	
	//删除一条记录
	public long deleteOnePosMarketingByYybh(long yybh) throws Exception;
	
	//更新一条记录
	public void updatePosMarketing(PosMarketing posMarketing) throws Exception;
	
	//获取一条手机银行营销登记记录
	public PosMarketing findPosMarketingByYybh(
			@Param("yybh") long yybh) throws Exception;
		
	//通过员工工号获取存款营销登记记录	
	public List<PosMarketing> findPosMarketingByYggh(
			@Param("yggh")String yggh,
			@Param("condition")String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("yggh")String yggh,
			@Param("condition")String condition) throws Exception;
	
	public List<PosMarketing> findAllPosMarketing() throws Exception;
	
	//获取新增POS机营销登记记录	
	public List<PosMarketing> findPosMarketingByPrefix(@Param("prefix") String prefix,
			@Param("len") int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public PosMarketing findPosMarketingExits(@Param("jgdm") String jgdm ,
		@Param("zjhm")String zjhm , @Param("yyrq")String yyrq) throws Exception;
}
