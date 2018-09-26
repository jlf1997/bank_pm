package com.readboy.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.readboy.ssm.mapper.MenuMapper;
import com.readboy.ssm.po.Menu;
import com.readboy.ssm.service.MenuService;

public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> findMenus() throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.findMenus();
	}

	@Override
	public void updateMenus(List<Menu> list) throws Exception {
		// TODO Auto-generated method stub
		menuMapper.updateMenus(list);
	}

	@Override
	public void updateMenu(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		menuMapper.updateMenu(menu);
	}
}
