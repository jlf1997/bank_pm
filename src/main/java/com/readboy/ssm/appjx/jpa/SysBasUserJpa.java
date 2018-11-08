package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.po.User;


/**
 * 类SysBasUserServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 17:13:19
 */

public interface SysBasUserJpa extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>  {
    
}