package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.MenuDao;
import org.spring.springboot.domain.Menu;
import org.spring.springboot.domain.UserMenu;
import org.spring.springboot.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private MenuDao menuDao;

	@Override
	public List<Menu> findMenu() {
		// TODO Auto-generated method stub
		return menuDao.findMenu();
	}

	@Override
	public List<UserMenu> findMenuByUserId(UserMenu userMenu) {
		// TODO Auto-generated method stub
		return menuDao.findMenuByUserId(userMenu);
	}

	@Override
	public Long saveUserMenu(UserMenu userMenu) {
		// TODO Auto-generated method stub
		return menuDao.saveUserMenu(userMenu);
	}

	@Override
	public Long deleteUserMenu(UserMenu userMenu) {
		// TODO Auto-generated method stub
		return menuDao.deleteUserMenu(userMenu);
	}

	
    
}
