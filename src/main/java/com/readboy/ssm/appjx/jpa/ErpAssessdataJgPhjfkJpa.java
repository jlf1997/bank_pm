package com.readboy.ssm.appjx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appjx.model.ErpAssessDataJgPhjfk;


/**
 * 类ErpAssessdataJgPhjfkServiceImpl的实现描述：
 * @author suhuanzhao 2018-11-08 19:25:45
 */

public interface ErpAssessdataJgPhjfkJpa extends JpaRepository<ErpAssessDataJgPhjfk, Long>,JpaSpecificationExecutor<ErpAssessDataJgPhjfk>  {
    
}