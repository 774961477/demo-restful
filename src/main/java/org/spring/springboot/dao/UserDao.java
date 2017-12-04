package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserDao {

    Long saveUser(User user);
    Long editUser(User user);
    List<User> findAllUser();
    List<User> findUserByOpenId(@Param("openId") String openId);
}
