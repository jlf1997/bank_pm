package com.readboy.ssm.appjx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readboy.ssm.appjx.dto.JGYJDto;
import com.readboy.ssm.appjx.service.ErpAssessdataJgPhjfkService;
import com.readboy.ssm.appjx.service.YyjjService;
import com.readboy.ssm.appnsh.dto.CDZLDto;
import com.readboy.ssm.appnsh.model.TB_TJFX_CDZL;
import com.readboy.ssm.appnsh.service.TB_TJFX_CDZLService;
import com.readboy.ssm.po.StaffAndPost;
import com.readboy.ssm.service.StaffAndPostService;
import com.readboy.ssm.utils.PageModel;
import com.readboy.ssm.utils.TimeUtil;


@RestController
@RequestMapping("/mobile/yj")
public class YjController {
	
	@Autowired
	private ErpAssessdataJgPhjfkService erpAssessdataJgPhjfkService;
	@Autowired
	private TB_TJFX_CDZLService tB_TJFX_CDZLService;
	
	
	@Autowired
	private StaffAndPostService staffAndPostService;
	@Autowired
	private YyjjService yyjjService;
	
	
	/**
	 * 机构业绩 按日
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param tjrq 统计日期
	 * @throws Exception 
	 */
	@RequestMapping(value="/day/jgyjIndex.action")
	public JGYJDto findYgyjMxDayPage(
			@RequestParam("yggh") String yggh,
			@RequestParam("tjrq") Long tjrq,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex
			) throws Exception {
			StaffAndPost snp = staffAndPostService.findStaffAndPostByYggh(yggh);
			if(snp==null) {
				return new JGYJDto();
			}
			Date time  = new Date(tjrq);
			Date b = TimeUtil.getTheFirstDayOfMonth(time);
			Date e = TimeUtil.getTheLastDayOfMonth(time);
			PageModel pm = erpAssessdataJgPhjfkService.findPage("DD",pageSize, pageIndex, snp.getZzbz(), b,e);
			JGYJDto dto = new JGYJDto();
			
			dto.setDf(erpAssessdataJgPhjfkService.getDf(snp.getZzbz(), time));
			dto.setYjmx(pm);
			return dto;
		
	}
	
	/**
	 * 机构业绩 按月
	 * @param yggh 员工工号
	 * @param zblb 指标类别
	 * @param tjrq 统计日期 
	 * @throws Exception 
	 */
	@RequestMapping(value="/month/jgyjIndex.action")
	public JGYJDto findYgyjMxMonthPage(
			@RequestParam("yggh") String yggh,
			@RequestParam("tjrq") Long tjrq,
			@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex
			) throws Exception {
			StaffAndPost snp = staffAndPostService.findStaffAndPostByYggh(yggh);
			if(snp==null) {
				return new JGYJDto();
			}
			Date time  = new Date(tjrq);
			Date b = TimeUtil.getTheFirstDayOfMonth(time);
			Date e = TimeUtil.getTheLastDayOfMonth(time);
			PageModel pm = erpAssessdataJgPhjfkService.findPage("MM",pageSize, pageIndex, snp.getZzbz(), b,e);
			JGYJDto dto = new JGYJDto();
			
			dto.setDf(erpAssessdataJgPhjfkService.getDf(snp.getZzbz(), time));
			dto.setYjmx(pm);
			return dto;
		
	}
	
	
	/**
	 * 个人业绩
	 * @param yggh
	 * @param tjrq
	 * @return
	 */
	@RequestMapping(value="/gryjIndex.action")
	public CDZLDto getGryj(
			@RequestParam("yggh") String yggh,
			@RequestParam("tjrq") Long tjrq
			) {
		Date b = TimeUtil.getStartTime(new Date(tjrq));
		Date e = TimeUtil.getEndTime(new Date(tjrq));
		List<TB_TJFX_CDZL> list = tB_TJFX_CDZLService.findByTime(yggh, b, e);
		CDZLDto res = new CDZLDto();
		if(list!=null && list.size()>0 && list.get(0)!=null) {
			BeanUtils.copyProperties(list.get(0), res);
		}
		
		return res;
		
	}
	/**
	 * 预约业绩
	 * @return
	 */
	@RequestMapping(value="/yyyjIndex.action")
	public Map<String,Object> getYyyj(
			@RequestParam("yggh") String yggh
			){
		Map<String,Object> map = new HashMap<>();
		//存款
		Long ckpp = yyjjService.getKhgxglCkkhyxdjbCount(yggh, 1);
		Long ckgq = yyjjService.getKhgxglCkkhyxdjbCount(yggh, -1);
		//手机银行
		Long sjpp = yyjjService.getKhgxglSjyhyxdjbServiceCount(yggh, 1);
		Long sjgq = yyjjService.getKhgxglSjyhyxdjbServiceCount(yggh, -1);
		map.put("ppxx", ckpp+sjpp);
		map.put("gqxx", ckgq+sjgq);
		return map;
	}
	
	
	
	
}
