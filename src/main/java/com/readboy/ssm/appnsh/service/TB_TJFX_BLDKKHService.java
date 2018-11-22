package com.readboy.ssm.appnsh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.dto.TB_TJFX_BLDKKHDto;
import com.readboy.ssm.appnsh.jpa.JdbcTemplatePageHelper;
import com.readboy.ssm.appnsh.model.TB_TJFX_BLDKKH;

@Service
public class TB_TJFX_BLDKKHService {
	@Autowired
	private OrgService orgService;
	

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplatePageHelper jdbcTemplatePageHelper;

	
	

	

	
	public int getCount(String yggh,int khlx) {
	
		String sql = "select * from tb_tjfx_bldkkh where yggh=? and khlx=? ";
		List<TB_TJFX_BLDKKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_BLDKKH>(TB_TJFX_BLDKKH.class));
		if(list!=null) {
			return list.size();
		}
		return 0;
		
	}
	
	public List<TB_TJFX_BLDKKHDto> getTB_TJFX_BLDKKHByYgghAndKHLX(String yggh,Integer khlx){
		String sql = "select * from tb_tjfx_bldkkh where yggh=? and khlx=? ";
		List<TB_TJFX_BLDKKH> list = jdbcTemplate.query(sql, new Object[] {yggh,khlx}
		,new BeanPropertyRowMapper<TB_TJFX_BLDKKH>(TB_TJFX_BLDKKH.class));
		return TB_TJFX_BLDKKHDto.copyList(list,orgService);
		
	}

//	public Map getPages(String yggh, Integer khlx, Integer pageSize, Integer pageIndex) {
//		// TODO Auto-generated method stub
//		String sql = " from tb_tjfx_bldkkh where yggh=? and khlx=? ";
//		RowMapper<TB_TJFX_BLDKKH> rowMap = new BeanPropertyRowMapper<TB_TJFX_BLDKKH>(TB_TJFX_BLDKKH.class);
//		Map map =  jdbcTemplatePageHelper.getPageMapTemp(sql, pageIndex, pageSize, rowMap, yggh,khlx);
//		List<TB_TJFX_BLDKKH> list = (List<TB_TJFX_BLDKKH>) map.get("content");
//		map.put("content", TB_TJFX_BLDKKHDto.copyList(list,orgService));
//		return map;
//	}
	
	
	public Map getPages(String yggh, Integer khlx, Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from tb_tjfx_bldkkh where yggh=? and khlx=? ";
		
		String sqlPage = "select tb.*,org.ZZMC as jgmc from tb_tjfx_bldkkh tb "
				+ "left join hr_bas_organization org on tb.jgdm = org.YWJGDM  where yggh=? and khlx=?";
		RowMapper<TB_TJFX_BLDKKHDto> rowMap = new BeanPropertyRowMapper<TB_TJFX_BLDKKHDto>(TB_TJFX_BLDKKHDto.class);
		Map map =  jdbcTemplatePageHelper.getPageMap(sqlPage,sql, pageIndex, pageSize, rowMap, yggh,khlx);
	
		return map;
	}
	
	

	
	
}
