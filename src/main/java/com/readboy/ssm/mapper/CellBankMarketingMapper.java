package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.CellBankMarketing;
import com.readboy.ssm.po.EtcMarketing;
import com.readboy.ssm.po.PageOption;
/*
 * 存款营销登记记录操作Mapper
 * */
public interface CellBankMarketingMapper {
	
 	//插入一条数据
	public long insertCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception;
	
	//删除一条记录
	public long deleteOneCellBankMarketingByYybh(long yybh) throws Exception;
	
	//更新一条记录
	public void updateCellBankMarketing(CellBankMarketing cellBankMarketing) throws Exception;
	
	//获取一条手机银行营销登记记录
	public CellBankMarketing findCellBankMarketingByYybh(long yybh) throws Exception;
		
	//获取全部存款营销登记记录	
	public List<CellBankMarketing> findAllCellBankMarketing() throws Exception;
	
	//条件查询手机银行营销登记记录	
	public List<CellBankMarketing> findCellBankMarketingByYggh(@Param("yggh") String yggh,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	
	public Integer findDataCountByCond(@Param("yggh") String yggh,
			@Param("condition") String condition) throws Exception;
	
	//获取新增全部手机银行营销登记记录	
	public List<CellBankMarketing> findCellBankMarketingByPrefix(@Param("prefix") String prefix,
				@Param("len") int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public CellBankMarketing findCellBankMarketingExits(@Param("jgdm")String jgdm,
		@Param("zjhm") String zjhm ,@Param("yyrq")String yyrq) throws Exception;
}
