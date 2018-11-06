package com.readboy.ssm.appnsh.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;

public interface TB_TJFX_CDZLJpa  extends JpaRepository<TB_TJFX_CDZL, Long>,JpaSpecificationExecutor<TB_TJFX_CDZL> {

}
