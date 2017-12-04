package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.springboot.common.utils.CheckUtil;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.common.utils.OpenIdUtil;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {

		List<User> list = new ArrayList<User>();
		list = userService.findUserByOpenId(user.getOpenId());
		if (list.size() <= 0) {
			user.setId(idGenerator.nextId());
			userService.saveUser(user);
		}

	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {

		List<User> list = new ArrayList<User>();
		list = userService.findUserByOpenId(user.getOpenId());
		return list.get(0);

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void editUser(@RequestBody User user) {
		userService.editUser(user);
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<User> listPage(@RequestBody PageBounds pageBounds) {

		PageHelper.startPage(pageBounds.getPageNum(), pageBounds.getPageSize());
		List<User> list = userService.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}

	@RequestMapping(value = "/getOpenId", method = RequestMethod.POST)
    public Map<String,String> getOpenId(@RequestBody User user) {
    	Map<String,String> returnMap = new HashMap<String, String>();
    	if (!CheckUtil.checkNulls( user.getCode())){
            //
            String openid = OpenIdUtil.oauth2GetOpenid(user.getCode());
            returnMap.put("openId", openid);
        }
    	return returnMap;
    	
    }

}
