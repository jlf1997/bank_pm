package com.readboy.ssm.mapper;

import com.readboy.ssm.po.EmployeeStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wyd on 2018/4/8.
 */
public interface AllStatisticMapper {

    /**
     * 根据日期查询全行排名前十的员工信息
     * @param GZRQ              日期
     * @return                  排名前十的员工信息
     * @throws Exception        异常信息
     */
    public List<EmployeeStatistics> findEmployeesByTime(@Param("GZRQ") String GZRQ) throws Exception;

    /**
     * 根据日期查找全行排名最大值
     * @param GZRQ      日期
     * @return          全行排名最大
     * @throws Exception      异常信息
     */
    public String findAllMaxNum(@Param("GZRQ") String GZRQ) throws Exception;


    /**
     * 获取全行后十名员工信息
     * @param GZRQ      日期
     * @param maxValue  最大值
     * @return          员工信息
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findAllLastTen(@Param("GZRQ") String GZRQ,@Param("maxValue") int maxValue) throws Exception;
}
