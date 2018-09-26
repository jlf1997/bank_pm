package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.exception.VisitException;

import com.readboy.ssm.mapper.VisitBasicInfoMapper;
import com.readboy.ssm.po.VisitBasicInfo;
import com.readboy.ssm.service.VisitBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Wyd on 2018/1/12.
 */
public class VisitBasicInfoServiceImpl implements VisitBasicInfoService {

    @Autowired
    private VisitBasicInfoMapper visitBasicInfoMapper;

    @Override
    public int insertVisitBasicInfo(VisitBasicInfo visitBasicInfo) throws Exception {
        int result = visitBasicInfoMapper.insert(visitBasicInfo);
        if (result<=0){
            throw new VisitException("插入拜访基本信息失败!");
        }
        return result;
    }

    @Override
    public List<VisitBasicInfo> findListBasicInfo(Map<String,Integer> map) throws Exception {
    	List<VisitBasicInfo> list = visitBasicInfoMapper.selectAllByVisitorIdAndClientNum(map);
        return list;
    }

}
