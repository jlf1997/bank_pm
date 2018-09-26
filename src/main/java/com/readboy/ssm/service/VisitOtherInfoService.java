package com.readboy.ssm.service;

import com.readboy.ssm.po.VisitOtherInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Wyd on 2018/1/12.
 * 拜访-其他信息业务层
 */
public interface VisitOtherInfoService {

    /**
     * 增加一条其他信息
     * @param visitOtherInfo 其他信息数据
     */
    int Insert(VisitOtherInfo visitOtherInfo);

    /**
     * 根据客户编码查询所有其他信息
     * @param khbm
     * @return
     */
    List<VisitOtherInfo> findListOtherInfo(Integer khbm);


    /**
     * 根据id删除一条数据
     * @param id  主键id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

}
