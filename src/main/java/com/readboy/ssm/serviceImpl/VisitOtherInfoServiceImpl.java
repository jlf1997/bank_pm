package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.mapper.VisitOtherInfoMapper;
import com.readboy.ssm.po.VisitOtherInfo;
import com.readboy.ssm.service.VisitOtherInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Wyd on 2018/1/16.
 * 拜访 其他信息
 */
public class VisitOtherInfoServiceImpl implements VisitOtherInfoService {

    @Autowired
    private VisitOtherInfoMapper visitOtherInfoMapper;

    @Override
    public int Insert(VisitOtherInfo visitOtherInfo) {
        int result = visitOtherInfoMapper.insert(visitOtherInfo);
        return result;
    }

    @Override
    public List<VisitOtherInfo> findListOtherInfo(Integer khbm) {
        List<VisitOtherInfo> listOtherInfo = visitOtherInfoMapper.findListOtherInfo(khbm);
        return listOtherInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        int result = visitOtherInfoMapper.deleteByPrimaryKey(id);
        return result;
    }
}
