package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.po.PageOption;
/*
 * 存款营销登记记录操作Mapper
 * */
public interface DepositMarketingMapper {
	
 	//插入一条数据
	public long insertDepositMarketing(DepositMarketing depositMarketing) throws Exception;
	
	//删除一条记录
	public long deleteOneDepositMarketingByYybh(long yybh) throws Exception;
	
	//更新一条记录
	public void updateDepositMarketing(DepositMarketing depositMarketing) throws Exception;
	
	//获取一条存款营销登记记录
	public DepositMarketing findDepositMarketingByYybh(@Param("yybh") long yybh) throws Exception;
		
	//条件查询存款营销登记
	public List<DepositMarketing> findDepositMarketingByYggh(@Param("yggh") String yggh,
			@Param("condition") String condition,@Param("page") PageOption page) throws Exception;
	
	public Integer findDataCountByCond(@Param("yggh") String yggh,
			@Param("condition") String condition) throws Exception;
	
	//获取全部存款营销登记记录
	public List<DepositMarketing> findAllDepositMarketing() throws Exception;
	
	//查询手机或PC端新增的存款营销记录，len是长度
	public List<DepositMarketing> findDepositMarketingByPrefix(@Param("prefix")String prefix,
			@Param("len") int len) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
	public DepositMarketing findDepoditMarketingExits(@Param("jgdm") String jgdm,
			@Param("zjhm") String zjhm ,@Param("yyrq")String yyrq) throws Exception;
	
	//查询一个机构的客户当前的预约日期是否存在记录
		public DepositMarketing findDepoditMarketingExitsForNewVersion(@Param("jgdm") String jgdm,
				@Param("khmc") String khmc,
				@Param("zjhm") String zjhm ,@Param("yyrq")String yyrq) throws Exception;

}
