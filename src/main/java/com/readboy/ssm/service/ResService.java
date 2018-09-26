package com.readboy.ssm.service;

import com.readboy.ssm.po.Res;

public interface ResService {
	
		//查询资源配置是否存在
		public Res findRes() throws Exception;
		
		//更新资源路径
		public long updateRes(String path) throws Exception;
		
		//插入数据
		public long insertRes(String path) throws Exception;
}
