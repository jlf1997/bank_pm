package com.readboy.ssm.appnsh.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.readboy.ssm.appnsh.model.Org;

public interface OrgJpa extends JpaRepository<Org, String>,JpaSpecificationExecutor<Org>{

}
