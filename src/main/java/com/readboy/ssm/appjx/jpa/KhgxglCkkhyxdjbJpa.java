package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;


/**
 * 类KhgxglCkkhyxdjbServiceImpl的实现描述：存款客户营销登记簿
 * @author suhuanzhao 2018-11-08 17:24:15
 */

public interface KhgxglCkkhyxdjbJpa extends JpaRepository<KhgxglCkkhyxdjb, Long>,JpaSpecificationExecutor<KhgxglCkkhyxdjb>  {
    
}