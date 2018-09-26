package com.readboy.ssm.service;

import java.util.List;

import com.readboy.ssm.po.Menu;
import com.readboy.ssm.po.MenuCustom;

public interface MenuService {
	
	public List<Menu> findMenus() throws Exception;
	
	public void updateMenus(List<Menu> list) throws Exception;
	
	public void updateMenu(Menu menu) throws Exception;
}
