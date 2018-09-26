package com.readboy.ssm.service;

import com.readboy.ssm.po.VisitBasicInfo;

import java.util.List;
import java.util.Map;

/**
 * 拜访系统的基本拜访信息服务层接口
 */
public interface VisitBasicInfoService {


    /**
     * 插入一条拜访的基本信息
     * @param visitBasicInfo 要插入的拜访基本信息
     * @return
     * @throws Exception
     */
    public int insertVisitBasicInfo(VisitBasicInfo visitBasicInfo) throws Exception;


    /**
     * 根据客户编号查询多条拜访信息
     * @param visitorId 员工编号
     * @param clientNum 客户编号
     * @return 查询的多条拜访信息
     * @throws Exception
     */
    public List<VisitBasicInfo> findListBasicInfo(Map<String,Integer> map) throws Exception;

}
