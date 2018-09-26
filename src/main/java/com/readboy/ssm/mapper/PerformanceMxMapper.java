package com.readboy.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.readboy.ssm.po.PerformanceMx;

public interface PerformanceMxMapper {

	public List<PerformanceMx> findPerformanceMx(
			@Param("yggh") String yggh,
			@Param("gzrq") String gzrq,
			@Param("zblb") int zblb) throws Exception;

}
