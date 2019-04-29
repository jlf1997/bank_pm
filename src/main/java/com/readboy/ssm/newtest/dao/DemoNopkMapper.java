package com.readboy.ssm.newtest.dao;

import com.readboy.ssm.newtest.domain.DemoNopk;
import java.util.List;	
import com.readboy.ssm.newtest.util.domain.PageData;
import com.readboy.ssm.newtest.util.domain.Assist;
import org.apache.ibatis.annotations.Param;

/**
 *  数据层
 * 
 * @author xiangy
 * @date 2019-04-29
 */
public interface DemoNopkMapper 
{
	
	
	
	/**
     * 新增
     * 
     * @param demoNopk 信息
     * @return 结果
     */
	public int insertDemoNopk(DemoNopk demoNopk);
	
	
	
	/**
	 * 获得Obj数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    public long getObjRowCountCommon(Assist assist);
    
    
	/**
	 * 获得Obj数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    public List<DemoNopk> selectListCommon(Assist assist);
    
     /**
	 * 条件更新
	 * @param assist
	 * @return
	 */
    public int updateObjCommon(@Param("value") DemoNopk value,@Param("assist") Assist assist);
    
    /**
    * 条件删除
    * @param assist
    */
    public int deleteObjCommon(Assist assist);
    
	
}