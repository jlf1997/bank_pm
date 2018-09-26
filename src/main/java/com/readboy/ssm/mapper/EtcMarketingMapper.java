package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
/*
 * 存款营销登记记录操作Mapper
 * */
public interface EtcMarketingMapper {
	
 	//插入一条数据
	public long insertEtcMarketing(EtcMarketing EtcMarketing) throws Exception;
	
	//删除一条记录
	public long deleteOneEtcMarketingByYybh(long yybh) throws Exception;
	
	//更新一条记录
	public void updateEtcMarketing(EtcMarketing etcMarketing) throws Exception;
	
	//获取一条etc营销登记记录
	public EtcMarketing findEtcMarketingByYybh(long yybh) throws Exception;
		
	//获取全部etc营销登记记录	
	public List<EtcMarketing> findAllEtcMarketing() throws Exception;
	
	
	//获取全部etc营销登记记录	
	public List<EtcMarketing> findEtcMarketingByYggh(@Param("yggh") String yggh,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(@Param("yggh") String yggh,
			@Param("condition") String condition) throws Exception;
	
	//获取新增全部etc营销登记记录	
	public List<EtcMarketing> findEtcMarketingByPrefix(@Param("prefix") String prefix,
			@Param("len") int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public EtcMarketing findEtcMarketingExits(@Param("jgdm")String jgdm,
			@Param("zjhm") String zjhm ,@Param("yyrq")String yyrq) throws Exception;
}
