package com.readboy.ssm.newtest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.readboy.ssm.newtest.dao.DemoQqMapper;
import com.readboy.ssm.newtest.domain.DemoQq;
import com.readboy.ssm.newtest.service.IDemoQqService;
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
public class DemoQqServiceImpl implements IDemoQqService 
{
	@Autowired
	private DemoQqMapper demoQqMapper;

	/**
     * 查询信息
     * 
     * @param id ID
     * @return 信息
     */
    @Override
	public DemoQq selectDemoQqById(Integer id)
	{
	    return demoQqMapper.selectDemoQqById(id);
	}
	
	/**
     * 查询列表
     * 
     * @param demoQq 信息
     * @return 集合
     */
	@Override
	public List<DemoQq> selectDemoQqList(DemoQq demoQq)
	{
		//demoQq.setDelFlag(DelStatus.NORMAL.getCode().toString());
	    return demoQqMapper.selectDemoQqList(demoQq);
	}
	
    /**
     * 新增
     * 
     * @param demoQq 信息
     * @return 结果
     */
	@Override
	public int insertDemoQq(DemoQq demoQq)
	{
	    return demoQqMapper.insertDemoQq(demoQq);
	}
	
	/**
     * 修改
     * 
     * @param demoQq 信息
     * @return 结果
     */
	@Override
	public int updateDemoQq(DemoQq demoQq)
	{
	    return demoQqMapper.updateDemoQq(demoQq);
	}

	/**
     * 删除对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDemoQqByIds(String ids)
	{
		Assert.notNull(ids, "ids is not null");
		return demoQqMapper.deleteDemoQqByIds(ids.split(","));
	}
	

	
	
	@Override
    public PageData<DemoQq> selectPageCommon(Assist assist, int page, int limit) {
        if (null == assist) {
    		assist = new Assist();
    	}
    	Assert.isTrue(page>0,"page is from 1");
		PageData<DemoQq> pageData = new PageData<>();
		Long count = this.getObjRowCountCommon(assist);
		int startRow = limit * (page - 1);
		assist.setStartRow(startRow);
		assist.setRowSize(limit);
		List<DemoQq> list = demoQqMapper.selectListCommon(assist);
		pageData.setCount(count.intValue());
		pageData.setList(list);
		return pageData;
    }
    
    
    @Override
	public List<DemoQq> selectListCommon(Assist assist) {
		if (null == assist) {
    		assist = new Assist();
    	}
		return demoQqMapper.selectListCommon(assist);
	}
	
	@Override
	public long getObjRowCountCommon(Assist assist) {
		if (null == assist) {
    		assist = new Assist();
    	}
		return demoQqMapper.getObjRowCountCommon(assist);
	}
	
	@Override
    public int updateObjCommon(DemoQq value, Assist assist) {
        int code = demoQqMapper.updateObjCommon(value, assist);
        return code;
    }
	
}
