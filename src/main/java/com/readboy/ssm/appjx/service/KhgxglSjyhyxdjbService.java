package com.readboy.ssm.appjx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.jpa.KhgxglSjyhyxdjbJpa;
import com.readboy.ssm.appjx.model.KhgxglSjyhyxdjb;
import com.readboy.ssm.appnsh.util.DefaultFinder;

@Service
public class KhgxglSjyhyxdjbService extends DefaultFinder<KhgxglSjyhyxdjb, Long>{
	
	
	@Autowired
	private KhgxglSjyhyxdjbJpa jpa;

	@Override
	public JpaSpecificationExecutor<KhgxglSjyhyxdjb> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<KhgxglSjyhyxdjb, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}




	
	
}
