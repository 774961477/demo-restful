package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Menu;
import org.spring.springboot.domain.UserMenu;
import org.spring.springboot.domain.UserMenuDto;
import org.spring.springboot.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private UserMenuService userMenuService;
	
	@Autowired
	private IdGenerator idGenerator;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createMenu(@RequestBody UserMenuDto userMenus) {
		UserMenu userMenu = new UserMenu();
		for(int i=0;i<userMenus.getMenuIds().size();i++){
			userMenu = new UserMenu();
			userMenu.setId(idGenerator.nextId());
			userMenu.setUserId(userMenus.getUserId());
			userMenu.setMenuId(userMenus.getMenuIds().get(i));
			userMenuService.saveUserMenu(userMenu);
		}
		
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteMenu(@RequestBody UserMenuDto userMenus) {
		UserMenu userMenu = new UserMenu();
		for(int i=0;i<userMenus.getMenuIds().size();i++){
			userMenu = new UserMenu();
			
			userMenu.setUserId(userMenus.getUserId());
			userMenu.setMenuId(userMenus.getMenuIds().get(i));
			userMenuService.deleteUserMenu(userMenu);
		}
		
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public List<Menu> list() {
		List<Menu> list = new ArrayList<Menu>();
		list = userMenuService.findMenu();
		return list;
		
	}
	
	@RequestMapping(value = "/listByUserId", method = RequestMethod.POST)
	public List<UserMenu> listByUserId(@RequestBody UserMenu userMenu) {
		List<UserMenu> list = new ArrayList<UserMenu>();
		list = userMenuService.findMenuByUserId(userMenu);
		return list;
	}
	
	
	 
	
	

	
}
