package com.readboy.ssm.mapper;


import org.apache.ibatis.annotations.Param;
import com.readboy.ssm.po.Res;
public interface ResMapper {
	
	//查询资源配置是否存在
	public Res findRes() throws Exception;
	
	public long insertRes(@Param("path") String path) throws Exception;
	
	//更新资源路径
	public long updateRes(@Param("path") String path) throws Exception;
	
}
