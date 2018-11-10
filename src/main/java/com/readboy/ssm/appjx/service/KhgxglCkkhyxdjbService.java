package com.readboy.ssm.appjx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.jpa.KhgxglCkkhyxdjbJpa;
import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;
import com.readboy.ssm.appnsh.util.DefaultFinder;

@Service
public class KhgxglCkkhyxdjbService extends DefaultFinder<KhgxglCkkhyxdjb, Long>{
	
	
	@Autowired
	private KhgxglCkkhyxdjbJpa jpa;

	@Override
	public JpaSpecificationExecutor<KhgxglCkkhyxdjb> specjpa() {
		// TODO Auto-generated method stub
		return jpa;
	}

	@Override
	public JpaRepository<KhgxglCkkhyxdjb, Long> jpa() {
		// TODO Auto-generated method stub
		return jpa;
	}



	
	
}
