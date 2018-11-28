package com.readboy.ssm.appjx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.KhgxglCkkhyxdjbDto;
import com.readboy.ssm.appjx.dto.KhgxglSjyhyxdjbDto;
import com.readboy.ssm.appjx.jpa.KhgxglCkkhyxdjbJpa;
import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;
import com.readboy.ssm.appnsh.util.DefaultFinder;

@Service
public class KhgxglCkkhyxdjbService extends DefaultFinder<KhgxglCkkhyxdjb, Long>{
	
	
	@Autowired
	private KhgxglCkkhyxdjbJpa jpa;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;

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

	public List<KhgxglCkkhyxdjbDto> getCk(Long yybh) {
		// TODO Auto-generated method stub
		String sql = "SELECT tb.*,org.ZZMC as jgmc  from khgxgl_ckkhyxdjb tb left JOIN hr_bas_organization org on tb.jgdm = org.YWJGDM"
				+ " where yybh=? ";
		
		RowMapper<KhgxglCkkhyxdjbDto> rowMapper = new BeanPropertyRowMapper<KhgxglCkkhyxdjbDto>(KhgxglCkkhyxdjbDto.class);
		
		return jdbcTemplate.query(sql, rowMapper,yybh);
	}



	
	
}
