package com.readboy.ssm.service;

import com.readboy.ssm.po.EmployeeStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支行排名前十的应该信息查询
 * Created by Wyd on 2018/4/8.
 */
public interface BranchStatisticsService {


    /**
     * 根据日期和支行或部门信息查询排名前十的员工信息
     * @param GZRQ          日期时间
     * @param ZZMC          支行部门信息
     * @return              排名前十的员工信息
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findEmployeesByOraganization (String GZRQ, String ZZMC) throws Exception;


    /**
     * 根据支行的日期和部门查询排名最大值
     * @param GZRQ      日期
     * @param ZZMC      支行
     * @return          支行排名最大值
     * @throws Exception    异常信息
     */
    public int findBranchMaxNum( String GZRQ,String ZZMC) throws Exception;


    /**
     * 查询支行的后十名
     * @param GZRQ      日期
     * @param ZZMC      支行
     * @param maxValue  支行排名最殴打致
     * @return          后十名员工信息
     * @throws Exception  异常信息
     */
    public List<EmployeeStatistics> findLastTen(String GZRQ,String ZZMC,int maxValue) throws Exception;
}
