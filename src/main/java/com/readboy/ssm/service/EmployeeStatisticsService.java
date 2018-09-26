package com.readboy.ssm.service;

import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.po.PageOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wyd on 2018/4/4.
 */
public interface EmployeeStatisticsService {

    //根据员工信息查询员工工资信息
    public List<EmployeeStatistics> findByTDNN(String gzrq,String zzmc,String yggh,PageOption page) throws Exception;


    //根据多个员工编号查询员工工资信息
    public List<EmployeeStatistics> findByTDNNS(String gzrq,String zzmc,List<String> ygghs,PageOption page) throws Exception;

    //根据员工姓名查询员工编号
    public List<String> findTELLIDByName(String name) throws Exception;

    //判断员工编号的姓名是否对应 是否是一个人
    public boolean judgeEmployee(String yggh, String ygxm)throws Exception;

    //查询所有部门信息
    public List<String> findOrganization() throws Exception;
}
