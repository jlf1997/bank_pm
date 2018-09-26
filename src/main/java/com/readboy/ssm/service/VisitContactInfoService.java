package com.readboy.ssm.service;

import com.readboy.ssm.po.VisitContactLog;

import java.util.List;

/**
 * Created by Wyd on 2018/1/12.
 * 拜访-联系人信息业务层
 */
public interface VisitContactInfoService {

    /**
     * 增加一条联系人通话记录
     * @param visitContactLog  新增的通话记录信息
     * @return
     * @throws Exception
     */
    public void insertContactInfo(VisitContactLog visitContactLog) throws Exception;


    /**
     * 通过客户编号查询拜访通话记录列表
     * @param clientNum  客户编号
     * @return            通话记录列表
     * @throws Exception
     */
    public List<VisitContactLog> findListContactLogByClientNum(int clientNum) throws Exception;

}
