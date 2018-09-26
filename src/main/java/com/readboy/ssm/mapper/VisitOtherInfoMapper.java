package com.readboy.ssm.mapper;

import com.readboy.ssm.po.VisitOtherInfo;

import java.util.List;

public interface VisitOtherInfoMapper {

    /**
     * 插入一条新数据
     * @param record
     * @return
     */
    int insert(VisitOtherInfo record);

    /**
     * 根据id删除一条数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    VisitOtherInfo selectByPrimaryKey(Integer id);


    /**
     * 根据id更新一条数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(VisitOtherInfo record);


    /**
     * 根据客户编码查询所有其他信息
     * @param clientNum 客户编码
     * @return
     */
    List<VisitOtherInfo> findListOtherInfo(Integer clientNum);
}