package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSDNFFExpireRecoveryRate;

/*
 * 包收当年发放当年到期回收率
 * */
public interface SimpleBSDNFFExpireRecoveryRateMapper {
	
	/*根据拓展人工号（user表中的telid）和到期时间去查询存款明细
	 * @Param bsrgh:包收人工号 , nd:年度
	 */
	public List<SimpleBSDNFFExpireRecoveryRate> findSimpleBSDNFFExpireRecoveryRate(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("jsrq") String jsrq) throws Exception;
}
