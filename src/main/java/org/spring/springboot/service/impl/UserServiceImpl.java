package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.UserDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao UserDao;

    
    @Override
    public Long saveUser(User user) {
        return UserDao.saveUser(user);
    }
    
    @Override
    public Long editUser(User user) {
        return UserDao.editUser(user);
    }
    public List<User> findAllUser(){
        return UserDao.findAllUser();
    }
    public List<User> findUserByOpenId(String openId){
        return UserDao.findUserByOpenId(openId);
    }
    
    
 

}
