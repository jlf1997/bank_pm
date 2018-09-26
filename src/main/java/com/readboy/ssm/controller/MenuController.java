package com.readboy.ssm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.readboy.ssm.po.Menu;
import com.readboy.ssm.po.MenuCustom;
import com.readboy.ssm.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/mobile/responseMenuJson.action")
	public List<Menu> responseMenuJson() throws Exception{
		List<Menu> MenuList = menuService.findMenus();
		return MenuList;
	}
	
	//----------PC端响应-------------
	@RequestMapping(value="/findMenus.action",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView findMenus(ModelAndView mv) throws Exception{
		List<Menu> list = menuService.findMenus();
		mv.addObject("list",list);
		mv.setViewName("apkmanager/apkMenu");
		return mv;
	}
	
	//批量更新菜单
	@RequestMapping(value="/updateMenus.action",method={RequestMethod.GET,RequestMethod.POST})
	public String updateMenus(MenuCustom menuCustom) throws Exception{
//		List<Menu> list = menuCustom.getMenuList();
//		for(Menu m : list){
//			menuService.updateMenu(m);			
//		}
		menuService.updateMenus(menuCustom.getMenuList());
		return "forward:/findMenus.action";
	}
	
	//批量更新菜单
	@RequestMapping(value="/updateMenu.action",method={RequestMethod.GET,RequestMethod.POST})
	public String updateMenus(Menu menu) throws Exception{
		menuService.updateMenu(menu);
		return "forward:/findMenus.action";
	}
}
