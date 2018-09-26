package com.readboy.ssm.mapper;

import java.util.List;
import java.util.Map;

import com.readboy.ssm.po.VisitFamilyInfo;

public interface VisitFamilyInfoMapper {


    /**
     * 插入一条数据
     * @param record
     * @return
     */
    int insert(VisitFamilyInfo record);

    /**
     * 根据id删除一条数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过id查询一条数据
     * @param id
     * @return
     */
    VisitFamilyInfo selectByPrimaryKey(Integer id);


    /**
     * 通过id更新一条数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(VisitFamilyInfo record);
    
    /**
     * 通过MemeberType和VisitorId和ClientNum查询数据
     * @param map
     * @return
     */
    List<VisitFamilyInfo> selectAllByMemeberTypeAndVisitorIdAndClientNum(Map<String, Object> map);


}