package com.readboy.ssm.mapper;

import com.readboy.ssm.po.EmployeeStatistics;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支行工资排名前十列表Mapper
 * Created by Wyd on 2018/4/8.
 */
public interface BranchStatisticsMapper {


    /**
     * 根据日期和支行查询支行排名前十的员工信息
     * @param GZRQ              日期
     * @param ZZMC     支行或部门
     * @return                  排名前十的员工信息
     * @throws Exception        异常信息
     */
    public List<EmployeeStatistics> findEmployeesByOraganization(@Param("GZRQ") String GZRQ,@Param("ZZMC") String ZZMC) throws Exception;

    /**
     * 根据支行的日期和部门查询排名最大值
     * @param GZRQ      日期
     * @param ZZMC      支行
     * @return          支行排名最大值
     * @throws Exception    异常信息
     */
    public String findBranchMaxNum(@Param("GZRQ") String GZRQ,@Param("ZZMC") String ZZMC) throws Exception;


    /**
     * 查询支行的后十名
     * @param GZRQ      日期
     * @param ZZMC      支行
     * @param maxValue  支行排名最殴打致
     * @return          后十名员工信息
     * @throws Exception  异常信息
     */
    public List<EmployeeStatistics> findLastTen(@Param("GZRQ") String GZRQ,@Param("ZZMC") String ZZMC,@Param("maxValue") int maxValue) throws Exception;
}
