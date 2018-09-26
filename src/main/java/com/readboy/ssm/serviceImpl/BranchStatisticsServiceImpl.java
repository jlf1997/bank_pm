package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.mapper.BranchStatisticsMapper;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.service.BranchStatisticsService;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 支行排名前十的应该信息查询实现类
 * Created by Wyd on 2018/4/8.
 */
public class BranchStatisticsServiceImpl implements BranchStatisticsService {
    @Autowired
    private BranchStatisticsMapper branchStatisticsMapper;
    @Override
    public List<EmployeeStatistics> findEmployeesByOraganization(String GZRQ, String ZZMC) throws Exception {
        List<EmployeeStatistics> employeeStatisticsList = branchStatisticsMapper.findEmployeesByOraganization(GZRQ, ZZMC);
        return employeeStatisticsList;
    }

    @Override
    public int findBranchMaxNum(String GZRQ, String ZZMC) throws Exception {
        String maxNum = branchStatisticsMapper.findBranchMaxNum(GZRQ, ZZMC);
        if (maxNum==null){
            return 0;
        }else {
            return Integer.valueOf(maxNum);
        }
    }

    @Override
    public List<EmployeeStatistics> findLastTen(String GZRQ, String ZZMC, int maxValue) throws Exception {
        List<EmployeeStatistics> lastTen = branchStatisticsMapper.findLastTen(GZRQ, ZZMC, maxValue);
        return lastTen;
    }
}
