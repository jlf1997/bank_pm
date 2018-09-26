package com.readboy.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleDepositExpireDetail;

public interface SimpleDepositExpireDetailService{
	
		//根据拓展人工号（user表中的telid）和到期时间去查询存款明细
		public List<SimpleDepositExpireDetail> findDepositExpireDetail(String tzrgh,String ksrq,
				String dqrq) throws Exception;
		
		public Integer findDataCountByCond(String tzrgh,String ksrq,
				String dqrq) throws Exception;
}
