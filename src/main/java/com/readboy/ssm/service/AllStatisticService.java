package com.readboy.ssm.service;

import com.readboy.ssm.po.EmployeeStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wyd on 2018/4/8.
 */
public interface AllStatisticService {

    /**
     * 查找全行前十名
     * @param GZRQ  日期
     * @return      前十名信息
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findEmployeesByTime(String GZRQ) throws Exception;


    /**
     * 全行排名最大值
     * @param GZRQ      日期
     * @return          全行排名最大
     * @throws Exception      异常信息
     */
    public int findAllMaxNum(String GZRQ) throws Exception;


    /**
     * 获取全行后十名员工信息
     * @param GZRQ      日期
     * @param maxValue  最大值
     * @return          员工信息
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findAllLastTen(String GZRQ,int maxValue) throws Exception;
}
