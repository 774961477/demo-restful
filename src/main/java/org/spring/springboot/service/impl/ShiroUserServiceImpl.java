package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.ShiroUserDao;
import org.spring.springboot.domain.ShiroUser;
import org.spring.springboot.service.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService {

    @Autowired
    private ShiroUserDao UserDao;

    
    @Override
    public Long saveShiroUser(ShiroUser user) {
        return UserDao.saveShiroUser(user);
    }
    public List<ShiroUser> findShiroUser(String loginName,String password){
        return UserDao.findShiroUser(loginName, password);
    }
	

}
