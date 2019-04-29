package com.readboy.ssm.newtest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.readboy.ssm.newtest.dao.DemoNopkMapper;
import com.readboy.ssm.newtest.domain.DemoNopk;
import com.readboy.ssm.newtest.service.IDemoNopkService;
import org.springframework.util.Assert;
import com.readboy.ssm.newtest.util.domain.PageData;
import com.readboy.ssm.newtest.util.domain.Assist;


/**
 *  服务层实现
 * 
 * @author xiangy
 * @date 2019-04-29
 */
@Service
public class DemoNopkServiceImpl implements IDemoNopkService 
{
	@Autowired
	private DemoNopkMapper demoNopkMapper;

	
	
	@Override
	public int insertDemoNopk(DemoNopk demoNopk)
	{
	    return demoNopkMapper.insertDemoNopk(demoNopk);
	}

	
	@Override
    public PageData<DemoNopk> selectPageCommon(Assist assist, int page, int limit) {
        if (null == assist) {
    		assist = new Assist();
    	}
    	Assert.isTrue(page>0,"page is from 1");
		PageData<DemoNopk> pageData = new PageData<>();
		Long count = this.getObjRowCountCommon(assist);
		int startRow = limit * (page - 1);
		assist.setStartRow(startRow);
		assist.setRowSize(limit);
		List<DemoNopk> list = demoNopkMapper.selectListCommon(assist);
		pageData.setCount(count.intValue());
		pageData.setList(list);
		return pageData;
    }
    
    
    @Override
	public List<DemoNopk> selectListCommon(Assist assist) {
		if (null == assist) {
    		assist = new Assist();
    	}
		return demoNopkMapper.selectListCommon(assist);
	}
	
	@Override
	public long getObjRowCountCommon(Assist assist) {
		if (null == assist) {
    		assist = new Assist();
    	}
		return demoNopkMapper.getObjRowCountCommon(assist);
	}
	
	@Override
    public int updateObjCommon(DemoNopk value, Assist assist) {
        int code = demoNopkMapper.updateObjCommon(value, assist);
        return code;
    }
    
     /**
	 * 条件删除
	 * @param assist
	 * @return
	 */
     public int deleteObjCommon(Assist assist){
     	return demoNopkMapper.deleteObjCommon(assist);
     }
    
    

	
}
