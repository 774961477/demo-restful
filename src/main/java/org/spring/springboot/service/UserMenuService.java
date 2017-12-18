package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Menu;
import org.spring.springboot.domain.UserMenu;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserMenuService {

	List<Menu> findMenu();

	List<UserMenu> findMenuByUserId(UserMenu userMenu);

	Long saveUserMenu(UserMenu userMenu);

	Long deleteUserMenu(UserMenu userMenu);

}
