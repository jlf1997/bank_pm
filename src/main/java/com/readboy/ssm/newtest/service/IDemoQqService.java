package com.readboy.ssm.newtest.service;

import com.readboy.ssm.newtest.domain.DemoQq;
import java.util.List;
import com.readboy.ssm.newtest.util.domain.PageData;
import com.readboy.ssm.newtest.util.domain.Assist;

/**
 *  服务层
 * 
 * @author xiangy
 * @date 2019-04-29
 */
public interface IDemoQqService 
{
	/**
     * 查询信息
     * 
     * @param id ID
     * @return 信息
     */
	public DemoQq selectDemoQqById(Integer id);
	
	/**
     * 查询列表
     * 
     * @param demoQq 信息
     * @return 集合
     */
	public List<DemoQq> selectDemoQqList(DemoQq demoQq);
	
	/**
     * 新增
     * 
     * @param demoQq 信息
     * @return 结果
     */
	public int insertDemoQq(DemoQq demoQq);
	
	/**
     * 修改
     * 
     * @param demoQq 信息
     * @return 结果
     */
	public int updateDemoQq(DemoQq demoQq);
		
	/**
     * 删除信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDemoQqByIds(String ids);
	
	
	
	/**
	* 	条件查询
	*/
	public List<DemoQq> selectListCommon(Assist assist);
	
	/**
	* 	分页查询
	*/
	public PageData<DemoQq> selectPageCommon(Assist assist, int page, int limit) ;
	
	
	/**
	 * 获得Obj数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    public long getObjRowCountCommon(Assist assist);
    
    
    /**
	 *  	条件更新
	 * @param assist
	 * @return
	 */
     public int updateObjCommon(DemoQq value, Assist assist);
	
}
