package com.readboy.ssm.serviceImpl;

import com.readboy.ssm.exception.VisitException;
import com.readboy.ssm.mapper.VisitBasicInfoMapper;
import com.readboy.ssm.mapper.VisitContactLogMapper;
import com.readboy.ssm.po.VisitContactLog;
import com.readboy.ssm.service.VisitContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wyd on 2018/1/12.
 */
public class VisitContactInfoServiceImpl implements VisitContactInfoService {

    @Autowired
    private VisitContactLogMapper visitContactLogMapper;

    @Override
    public void insertContactInfo(VisitContactLog visitContactLog) throws Exception {
        visitContactLogMapper.insert(visitContactLog);
    }

    /**
     * 通过客户编号查询拜访通话记录列表
     * @param clientNum  客户编号
     * @return            通记录列表
     * @throws Exception
     */
    @Override
    public List<VisitContactLog> findListContactLogByClientNum(int clientNum) throws Exception {
        List<VisitContactLog> listContactLog = visitContactLogMapper.findListContactLogByClientNum(clientNum);
        return listContactLog;
    }

}
