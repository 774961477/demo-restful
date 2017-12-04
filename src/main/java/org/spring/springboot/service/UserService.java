package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.User;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveUser(User User);
    Long editUser(User User);
    
    List<User> findAllUser();
    
    List<User> findUserByOpenId(String openId);
 
}
