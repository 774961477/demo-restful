package org.spring.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.springboot.common.utils.AccessTokenUtil;
import org.spring.springboot.common.utils.HttpUtil;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.CompanyJoin;
import org.spring.springboot.domain.CompanyJoinDto;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.ShiroUser;
import org.spring.springboot.domain.TemplateData;
import org.spring.springboot.domain.WxTemplate;
import org.spring.springboot.service.CompanyJoinService;
import org.spring.springboot.service.ShiroUserService;
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
@RequestMapping(value = "/companyjoin")
public class CompanyJoinController {

	@Autowired
	private CompanyJoinService companyJoinService;
	@Autowired
	private ShiroUserService shiroUserService;
	@Autowired
	private IdGenerator idGenerator;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createCompanyJoin(@RequestBody CompanyJoin companyJoin) {
		companyJoin.setId(idGenerator.nextId());
		companyJoinService.saveCompanyJoin(companyJoin);
	}

	@RequestMapping(value = "/addCompanyUser", method = RequestMethod.POST)
    public Map<String,String> addCompanyUser(@RequestBody CompanyJoinDto companyJoinDto) {
    	String id = companyJoinDto.getId();
    	ShiroUser shiroUser = new ShiroUser();
    	shiroUser.setUserName(companyJoinDto.getUserName());
    	shiroUser.setLoginName(companyJoinDto.getLoginName());
    	shiroUser.setPassword(companyJoinDto.getPassword());
    	shiroUser.setId(idGenerator.nextId());
    	shiroUser.setRoleId(0);
    	shiroUser.setState("A");
    	shiroUserService.saveShiroUser(shiroUser);
    	Map<String,String> map = new HashMap<String, String>();
    	
    	
    	map.put("state", "200");
    	
    	this.sendMessage(companyJoinDto);
    	CompanyJoin companyJoin = new CompanyJoin();
    	companyJoin.setSendMessage("A");
    	companyJoin.setId(id);
    	companyJoinService.editCompanyJoin(companyJoin);
    	return map;
    }

	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<CompanyJoin> listPage(@RequestBody PageBounds pageBounds) {
		PageHelper.startPage(pageBounds.getPageNum(), pageBounds.getPageSize());
		List<CompanyJoin> list = companyJoinService.findAllCompanyJoin();
		PageInfo<CompanyJoin> pageInfo = new PageInfo<CompanyJoin>(list);
		return pageInfo;
	}

	private void sendMessage(CompanyJoinDto companyJoinDto) {
		//loUjgu9Oner2Sy1USDwKk_CrY89_teWEsOesjNgMiHw
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + AccessTokenUtil.accessToken.getAccess_token();
		WxTemplate temp = new WxTemplate();
		
		temp.setTouser(companyJoinDto.getOpenId());
		temp.setForm_id(companyJoinDto.getFormId());
		temp.setTemplate_id("loUjgu9Oner2Sy1USDwKk_CrY89_teWEsOesjNgMiHw");
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(companyJoinDto.getUserName());
		m.put("keyword1", keyword1);
		
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue("通过");
		m.put("keyword2", keyword2);
		
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#000000");
		keyword3.setValue("用户名："+companyJoinDto.getLoginName()+"密码："+companyJoinDto.getPassword());
		m.put("keyword3", keyword3);
		
		
		temp.setData(m);
		String jsonString = JSONObject.toJSONString(temp).toString();
		
		String result = HttpUtil.sendPost(url, jsonString);
		System.out.println(result); 
		
	}
}
