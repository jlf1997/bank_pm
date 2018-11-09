package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appjx.model.ErpBasZbk;
import com.readboy.ssm.appjx.model.pk.ErpBasZbkPk;


/**
 * 类ErpBasZbkServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 19:41:23
 */

public interface ErpBasZbkJpa extends JpaRepository<ErpBasZbk, ErpBasZbkPk>,JpaSpecificationExecutor<ErpBasZbk>  {
    
}