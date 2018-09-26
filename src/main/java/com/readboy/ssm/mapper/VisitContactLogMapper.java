package com.readboy.ssm.mapper;

import com.readboy.ssm.po.VisitContactLog;

import java.util.List;

public interface VisitContactLogMapper {


    /**
     * 插入一条数据
     * @param record
     * @return
     */
     void insert(VisitContactLog record);

    /**
     * 通过id删除一条数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过id查询一条数据
     * @param id
     * @return
     */
    VisitContactLog selectByPrimaryKey(Integer id);


    /**
     * 通过主键更新一条数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(VisitContactLog record);

    /**
     * 通过客户编号查询通话记录列表
     * @param clinetNum    客户编号
     * @return             通话记录列表
     */
    List<VisitContactLog> findListContactLogByClientNum(int clinetNum);
}