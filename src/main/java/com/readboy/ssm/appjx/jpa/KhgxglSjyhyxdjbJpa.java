package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.po.CellBankMarketing;


/**
 * 类KhgxglSjyhyxdjbServiceImpl的实现描述：手机银行营销登记簿
 * @author suhuanzhao 2018-11-08 17:24:15
 */

public interface KhgxglSjyhyxdjbJpa extends JpaRepository<CellBankMarketing, Long>,JpaSpecificationExecutor<CellBankMarketing>  {
    
}