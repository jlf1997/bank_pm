package com.readboy.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.readboy.ssm.po.VisitBasicInfo;

public interface VisitBasicInfoMapper {


    /**
     * 插入一条数据
     * @param record 一条数据
     * @return
     */
    int insert(VisitBasicInfo record);

    /**
     * 通过主键删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 通过主键查询一条数据
     * @param id
     * @return
     */
    VisitBasicInfo selectByPrimaryKey(Integer id);

    /**
     * 通过主键更新一条数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(VisitBasicInfo record);
    
    /**
     * 通过VisitorId和ClientNum查询数据
     * @param map
     * @return
     */
    List<VisitBasicInfo> selectAllByVisitorIdAndClientNum(Map<String,Integer> map);
}