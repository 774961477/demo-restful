package org.spring.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.springboot.common.utils.AccessTokenUtil;
import org.spring.springboot.common.utils.HttpUtil;
import org.spring.springboot.common.utils.HttpUtils;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.common.utils.WeixinUtil;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.ShiroUser;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.domain.StoreJoinDto;
import org.spring.springboot.domain.TemplateData;
import org.spring.springboot.domain.WxTemplate;
import org.spring.springboot.service.ShiroUserService;
import org.spring.springboot.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/storejoin")
public class StoreJoinController {

	@Autowired
	private StoreJoinService storeJoinService;
	@Autowired
	private ShiroUserService shiroUserService;
	@Autowired
	private IdGenerator idGenerator;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createStoreJoin(@RequestBody StoreJoin storeJoin) {
		storeJoin.setId(idGenerator.nextId());
		storeJoinService.saveStoreJoin(storeJoin);
	}

	@RequestMapping(value = "/addStoreUser", method = RequestMethod.POST)
    public Map<String,String> addStoreUser(@RequestBody StoreJoinDto storeJoinDto) {
    	String id = storeJoinDto.getId();
    	ShiroUser shiroUser = new ShiroUser();
    	shiroUser.setUserName(storeJoinDto.getUserName());
    	shiroUser.setLoginName(storeJoinDto.getLoginName());
    	shiroUser.setPassword(storeJoinDto.getPassword());
    	shiroUser.setId(idGenerator.nextId());
    	shiroUser.setRoleId(0);
    	shiroUser.setState("A");
    	shiroUserService.saveShiroUser(shiroUser);
    	Map<String,String> map = new HashMap<String, String>();
    	
    	
    	map.put("state", "200");
    	
    	this.sendMessage(storeJoinDto);
    	StoreJoin storeJoin = new StoreJoin();
    	storeJoin.setSendMessage("A");
    	storeJoin.setId(id);
    	storeJoinService.editStoreJoin(storeJoin);
    	return map;
    }

	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<StoreJoin> listPage(@RequestBody PageBounds pageBounds) {
		PageHelper.startPage(pageBounds.getPageNum(), pageBounds.getPageSize());
		List<StoreJoin> list = storeJoinService.findAllStoreJoin();
		PageInfo<StoreJoin> pageInfo = new PageInfo<StoreJoin>(list);
		return pageInfo;
	}

	private void sendMessage(StoreJoinDto storeJoinDto) {
		//loUjgu9Oner2Sy1USDwKk_CrY89_teWEsOesjNgMiHw
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + AccessTokenUtil.accessToken.getAccess_token();
		WxTemplate temp = new WxTemplate();
		
		temp.setTouser(storeJoinDto.getOpenId());
		temp.setForm_id(storeJoinDto.getFormId());
		temp.setTemplate_id("loUjgu9Oner2Sy1USDwKk_CrY89_teWEsOesjNgMiHw");
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(storeJoinDto.getUserName());
		m.put("keyword1", keyword1);
		
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue("通过");
		m.put("keyword2", keyword2);
		
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#000000");
		keyword3.setValue("用户名："+storeJoinDto.getLoginName()+"密码："+storeJoinDto.getPassword());
		m.put("keyword3", keyword3);
		
		
		temp.setData(m);
		String jsonString = JSONObject.toJSONString(temp).toString();
		
		String result = HttpUtil.sendPost(url, jsonString);
		System.out.println(result); 
		
	}
}
