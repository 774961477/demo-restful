package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.ShiroUser;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ShiroUserService {

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveShiroUser(ShiroUser User);
    
    List<ShiroUser> findShiroUser(String loginName,String password);
    
    List<ShiroUser> listShiroUser();
    
    void deletShiroUser(ShiroUser shiroUser);
 
}
