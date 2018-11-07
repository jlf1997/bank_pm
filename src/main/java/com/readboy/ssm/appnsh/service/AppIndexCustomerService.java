package com.readboy.ssm.appnsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.readboy.ssm.appnsh.model.TB_TJFX_CDKPM;
import com.readboy.ssm.appnsh.util.Finder;

@Service
public class AppIndexCustomerService {

	@Autowired
	private TB_TJFX_CDKPMService tB_TJFX_CDKPMService;
	
	
	/**
	 * 获取存贷排名top10
	 * @param ywlx 业务类型
	 * @return
	 */
	public List<TB_TJFX_CDKPM> getcdTop10(int ywlx,String yggh) {
		Sort sort = new Sort(Direction.DESC,"je");
		PageRequest pr = new PageRequest(0,10,sort);
		TB_TJFX_CDKPM pm = new TB_TJFX_CDKPM();
		pm.setYwlx(ywlx);
		pm.setYggh(yggh);
		Page<TB_TJFX_CDKPM>	page = tB_TJFX_CDKPMService.findAllPage(pr, pm);
		return page.getContent();
		
	}
}
