package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.ShiroUser;
import org.spring.springboot.service.ShiroUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class ShiroUserController {
	
    @Autowired
    private ShiroUserService shiroUserService;
     
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody ShiroUser shiroUser) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<ShiroUser> list = new ArrayList<ShiroUser>();
    	list = shiroUserService.findShiroUser(shiroUser.getLoginName(), shiroUser.getPassword());
    	if(list.size() > 0){
    		map.put("msg", "登录成功");
    		map.put("code", "200");
    		map.put("user", list.get(0));
    	}else{
    		map.put("msg", "登录失败");
    		map.put("code", "400");
    	}
    	return map;
    }
    
    
}
