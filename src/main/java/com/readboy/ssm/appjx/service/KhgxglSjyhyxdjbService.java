package com.readboy.ssm.appjx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.KhgxglSjyhyxdjbDto;
import com.readboy.ssm.appjx.jpa.KhgxglSjyhyxdjbJpa;
import com.readboy.ssm.appjx.model.KhgxglSjyhyxdjb;
import com.readboy.ssm.appnsh.util.DefaultFinder;

@Service
public class KhgxglSjyhyxdjbService extends DefaultFinder<KhgxglSjyhyxdjb, Long>{
	
	
	@Autowired
	private KhgxglSjyhyxdjbJpa jpa;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

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

	public List<KhgxglSjyhyxdjbDto> getSj(Long yybh) {
		// TODO Auto-generated method stub
		String sql = "SELECT tb.*,org.ZZJC as jgmc  from khgxgl_sjyhyxdjb tb left JOIN hr_bas_organization org on tb.jgdm = org.YWJGDM"
				+ " where yybh=?  ";
		
		RowMapper<KhgxglSjyhyxdjbDto> rowMapper = new BeanPropertyRowMapper<KhgxglSjyhyxdjbDto>(KhgxglSjyhyxdjbDto.class);
		
		return jdbcTemplate.query(sql, rowMapper,yybh);
	}

	public void update(Integer sbzt, Long yybh) {
		// TODO Auto-generated method stub
		String sql = "update khgxgl_sjyhyxdjb set sbzt = ? where yybh=?";
		jdbcTemplate.update(sql,sbzt,yybh);
	}




	
	
}
