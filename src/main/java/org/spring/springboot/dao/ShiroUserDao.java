package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.ShiroUser;

/**
 * DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ShiroUserDao {

    Long saveShiroUser(ShiroUser user);
    List<ShiroUser> findShiroUser(@Param("loginName") String loginName,@Param("password") String password);
}
