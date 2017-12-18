package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.Menu;
import org.spring.springboot.domain.UserMenu;


public interface MenuDao {

    /**
     * 获取
     *
     * @return
     */
    List<Menu> findMenu();
    List<UserMenu> findMenuByUserId(UserMenu userMenu);
    
    Long saveUserMenu(UserMenu userMenu);
    
    Long deleteUserMenu(UserMenu userMenu);

}
