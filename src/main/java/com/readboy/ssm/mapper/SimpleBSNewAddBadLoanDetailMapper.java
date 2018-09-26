package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.SimpleBSLoanExpireDetail;
import com.readboy.ssm.po.SimpleBSNewAddBadLoanDetail;

/*包收新增不良贷款明细Mapper
 * */
public interface SimpleBSNewAddBadLoanDetailMapper {
	
	/*根据拓展人工号（user表中的telid）和到期时间去查询存款明细
	 * @Param bsrgh:包收人人工号 , ksrq:开始日期 , dqrq:到期日期
	 */
	public List<SimpleBSNewAddBadLoanDetail> findSimpleBSNewAddBadLoanDetail(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
	
	public Integer findDataCountByCond(
			@Param("bsrgh")String bsrgh, @Param("ksrq") String ksrq,
			@Param("dqrq") String dqrq) throws Exception;
}
