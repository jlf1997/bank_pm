package com.readboy.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import com.readboy.ssm.po.PerformanceDKWddkhsMx;

public interface PerformanceDKWddkhsMxMapper {
    
	public PerformanceDKWddkhsMx findPerformanceDKWddkhsMx(
			@Param("ksrq")String ksrq,@Param("jsrq")String jsrq,
			@Param("zzbz")String zzbz) throws Exception;
	
}