package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.dto.TB_TJFX_CKDQKHDto;
import com.readboy.ssm.appnsh.model.TB_TJFX_CKDQKH;

@Service
public class TB_TJFX_CKDQKHService {
	
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	public int getCount(String yggh,int khlx) {
		String sql = "select * from tb_tjfx_ckdqkh where yggh=? and khlx=? ";
		List<TB_TJFX_CKDQKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_CKDQKH>(TB_TJFX_CKDQKH.class));
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}

	public List<TB_TJFX_CKDQKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		String sql = "select * from tb_tjfx_ckdqkh where yggh=? and khlx=? ";
		List<TB_TJFX_CKDQKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_CKDQKH>(TB_TJFX_CKDQKH.class));
		return TB_TJFX_CKDQKHDto.copyList(list,orgService);
		
	}

	
}
