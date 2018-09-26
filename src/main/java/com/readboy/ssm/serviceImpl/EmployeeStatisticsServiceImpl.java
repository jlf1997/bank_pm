package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.mapper.EmployeeStatisticsMapper;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.EmployeeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 根据员工信息查询员工工资信息
 * Created by Wyd on 2018/4/4.
 */
public class EmployeeStatisticsServiceImpl implements EmployeeStatisticsService {

    @Autowired
    private EmployeeStatisticsMapper employeeStatisticsMapper;
    @Override
    public List<EmployeeStatistics> findByTDNN(String gzrq,String zzmc,String yggh,PageOption page) throws Exception {
        List<EmployeeStatistics> statisticsList = employeeStatisticsMapper.findByTDNN(gzrq,zzmc,yggh,page);
        return statisticsList;
    }

    @Override
    public List<EmployeeStatistics> findByTDNNS(String gzrq, String zzmc, List<String> ygghs, PageOption page) throws Exception {
        List<EmployeeStatistics> statisticsList = employeeStatisticsMapper.findByTDNNS(gzrq, zzmc, ygghs, page);
        return statisticsList;
    }

    @Override
    public List<String> findTELLIDByName(String name) throws Exception {
        List<String> tellIds = employeeStatisticsMapper.findTELLIDByName(name);
        return tellIds;
    }

    @Override
    public boolean judgeEmployee(String yggh, String ygxm) throws Exception {
        int num = employeeStatisticsMapper.judgeEmployee(yggh, ygxm);
        if (num>0){
            return true;
        }
        return false;
    }

    @Override
    public List<String> findOrganization() throws Exception {
        List<String> organizations = employeeStatisticsMapper.findOrganization();
        return organizations;
    }
}
