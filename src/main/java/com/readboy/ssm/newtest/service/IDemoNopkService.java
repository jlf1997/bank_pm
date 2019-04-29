package com.readboy.ssm.newtest.service;

import com.readboy.ssm.newtest.domain.DemoNopk;
import java.util.List;
import com.readboy.ssm.newtest.util.domain.PageData;
import com.readboy.ssm.newtest.util.domain.Assist;

/**
 *  服务层
 * 
 * @author xiangy
 * @date 2019-04-29
 */
public interface IDemoNopkService 
{
	/**
     * 新增
     * 
     * @param demoNopk 信息
     * @return 结果
     */
	public int insertDemoNopk(DemoNopk demoNopk);
	
	
	/**
	* 	条件查询
	*/
	public List<DemoNopk> selectListCommon(Assist assist);
	
	/**
	* 	分页查询
	*/
	public PageData<DemoNopk> selectPageCommon(Assist assist, int page, int limit) ;
	
	
	/**
	 * 获得Obj数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    public long getObjRowCountCommon(Assist assist);
    
    
    /**
	 * 条件更新
	 * @param assist
	 * @return
	 */
     public int updateObjCommon(DemoNopk value, Assist assist);
     
     
      /**
	 * 条件删除
	 * @param assist
	 * @return
	 */
     public int deleteObjCommon(Assist assist);
     
     
     
	
}
