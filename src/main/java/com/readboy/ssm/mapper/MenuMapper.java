package com.readboy.ssm.mapper;

import java.util.List;

import com.readboy.ssm.po.Menu;
import com.readboy.ssm.po.MenuCustom;

public interface MenuMapper {
	
	//查询所有菜单信息
	public List<Menu> findMenus() throws Exception;
	
	//更改菜单显示状态
	
	public void updateMenus(List<Menu> list) throws Exception;
	
	public void updateMenu(Menu menu) throws Exception;
}
