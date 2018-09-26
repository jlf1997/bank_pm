package com.readboy.ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanExpireDetail;
/*
 * 包收存款到期明细
 * */
public interface SimpleBSLoanExpireDetailMapper {

	/*根据拓展人工号（user表中的telid）和到期时间去查询存款明细
	 * @Param bsrgh:拓展人工号 , ksrq:开始日期 , dqrq:到期日期
	 */
	public List<SimpleBSLoanExpireDetail> findSimpleBSLoanExpireDetail(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
}
