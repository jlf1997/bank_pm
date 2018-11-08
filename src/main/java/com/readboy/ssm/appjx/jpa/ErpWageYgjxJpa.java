package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appjx.model.JXPK;
import com.readboy.ssm.po.Performance;


/**
 * 类ErpWageYgjxServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 17:24:15
 */

public interface ErpWageYgjxJpa extends JpaRepository<Performance, JXPK>,JpaSpecificationExecutor<Performance>  {
    
}