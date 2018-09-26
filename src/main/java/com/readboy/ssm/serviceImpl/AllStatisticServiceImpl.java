package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.mapper.AllStatisticMapper;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.service.AllStatisticService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Wyd on 2018/4/8.
 */
public class AllStatisticServiceImpl implements AllStatisticService {

    @Autowired
    private AllStatisticMapper allStatisticMapper;
    @Override
    public List<EmployeeStatistics> findEmployeesByTime(String GZRQ) throws Exception {
        List<EmployeeStatistics> statisticsList = allStatisticMapper.findEmployeesByTime(GZRQ);
        return statisticsList;
    }

    @Override
    public int findAllMaxNum(String GZRQ) throws Exception {
        String maxNum = allStatisticMapper.findAllMaxNum(GZRQ);
        if(maxNum==null){
        	return 0;
        }
        return Integer.valueOf(maxNum);
    }

    @Override
    public List<EmployeeStatistics> findAllLastTen(String GZRQ, int maxValue) throws Exception {
        List<EmployeeStatistics> lastTen = allStatisticMapper.findAllLastTen(GZRQ, maxValue);
        return lastTen;
    }
}
