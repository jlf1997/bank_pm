package com.readboy.ssm.appjx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appjx.dto.KhgxglCkkhyxdjbDto;
import com.readboy.ssm.appjx.jpa.KhgxglCkkhyxdjbJpa;
import com.readboy.ssm.appjx.model.KhgxglCkkhyxdjb;
import com.readboy.ssm.appnsh.util.DefaultFinder;
import com.readboy.ssm.mapper.DepositMarketingMapper;
import com.readboy.ssm.po.DepositMarketing;
import com.readboy.ssm.utils.LogsUtil;

@Service
public class KhgxglCkkhyxdjbService extends DefaultFinder<KhgxglCkkhyxdjb, Long>{
	
	private static final Logger log = LoggerFactory.getLogger(KhgxglCkkhyxdjbService.class);
	@Autowired
	private KhgxglCkkhyxdjbJpa jpa;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DepositMarketingMapper mapper;

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
		String sql = "SELECT tb.*,org.ZZJC as jgmc  from khgxgl_ckkhyxdjb tb left JOIN hr_bas_organization org on tb.jgdm = org.YWJGDM"
				+ " where yybh=?  ";
		
		RowMapper<KhgxglCkkhyxdjbDto> rowMapper = new BeanPropertyRowMapper<KhgxglCkkhyxdjbDto>(KhgxglCkkhyxdjbDto.class);
		
		return jdbcTemplate.query(sql, rowMapper,yybh);
	}
	
	public void update(Integer sbzt,Long yybh) {
		String sql = "update khgxgl_ckkhyxdjb set sbzt = ? where yybh=?";
		jdbcTemplate.update(sql,sbzt,yybh);
	}
	
	public void insert(DepositMarketing obj) {
		try {
			mapper.insertDepositMarketing(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(LogsUtil.getStackTrace(e));
		}
	}



	
	
}
