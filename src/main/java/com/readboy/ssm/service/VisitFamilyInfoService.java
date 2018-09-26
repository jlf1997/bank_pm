package com.readboy.ssm.service;

import java.util.List;
import java.util.Map;

import com.readboy.ssm.po.VisitFamilyInfo;

/**
 * 拜访系统的家庭信息服务层接口
 */
public interface VisitFamilyInfoService {
	
	/**
     * 按条件查询家庭信息
     * @param map 按map里的信息查询
     * @return
     * @throws Exception
     */
	List<VisitFamilyInfo> findListFamilyInfo(Map<String, Object> map);
	
	/**
     * 插入一条家庭成员信息
     * @param familyInfo 要插入的家庭成员信息
     * @return
     * @throws Exception
     */
	void insertVisitFamilyInfo(VisitFamilyInfo familyInfo);
	
	/**
     * 删除一条家庭成员信息
     * @param
     * @return
     * @throws Exception
     */
	void deleteById(int id);



	
}
