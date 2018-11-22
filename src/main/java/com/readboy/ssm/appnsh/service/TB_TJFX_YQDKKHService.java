package com.readboy.ssm.appnsh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.dto.TB_TJFX_CKDKHDto;
import com.readboy.ssm.appnsh.dto.TB_TJFX_YQDKKHDto;
import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;
import com.readboy.ssm.appnsh.model.TB_TJFX_YQDKKH;

@Service
public class TB_TJFX_YQDKKHService {
	
	
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;

	

	public int getCount(String yggh,int khlx) {
		String sql = "select * from tb_tjfx_yqdkkh where yggh=? and khlx=? ";
		List<TB_TJFX_YQDKKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_YQDKKH>(TB_TJFX_YQDKKH.class));
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_YQDKKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		String sql = "select * from tb_tjfx_yqdkkh where yggh=? and khlx=? ";
		List<TB_TJFX_YQDKKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_YQDKKH>(TB_TJFX_YQDKKH.class));
		return TB_TJFX_YQDKKHDto.copyList(list,orgService);

		
	}
	
	public Map getPages(String yggh, Integer khlx, Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from tb_tjfx_yqdkkh where yggh=? and khlx=? ";
		
		String sqlPage = "select tb.*,org.ZZMC as jgmc from tb_tjfx_yqdkkh tb "
				+ "left join hr_bas_organization org on tb.jgdm = org.YWJGDM  where yggh=? and khlx=?";
		RowMapper<TB_TJFX_YQDKKHDto> rowMap = new BeanPropertyRowMapper<TB_TJFX_YQDKKHDto>(TB_TJFX_YQDKKHDto.class);
		Map map =  jdbcTemplatePageHelper.getPageMap(sqlPage,sql, pageIndex, pageSize, rowMap, yggh,khlx);
	
		return map;
	}


	
}
