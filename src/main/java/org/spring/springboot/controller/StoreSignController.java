package org.spring.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.spring.springboot.common.utils.AccessTokenUtil;
import org.spring.springboot.common.utils.HttpUtil;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.SignPage;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.StoreSignUpDto;
import org.spring.springboot.domain.TemplateData;
import org.spring.springboot.domain.WxTemplate;
import org.spring.springboot.service.StoreSignService;
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
@RequestMapping(value = "/storesign")
public class StoreSignController {

    @Autowired
    private StoreSignService storeSignService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createStoreSign(@RequestBody StoreSignUp storeSignUp) {
    	storeSignUp.setId(idGenerator.nextId());
    	storeSignService.saveStoreSign(storeSignUp);
    }
    
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public void notice(@RequestBody StoreSignUp storeSignUp) {
    	storeSignService.editStoreSign(storeSignUp);
    	
    	this.sendMessage(storeSignUp);
    }
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageInfo<StoreSignUpDto> listPage(@RequestBody SignPage signPage) {
        PageHelper.startPage(signPage.getPageNum(), signPage.getPageSize());
        StoreSignUp storeSignUp = new StoreSignUp();
        if(StringUtils.isNotBlank(signPage.getOpenId())){
        	storeSignUp.setOpenId(signPage.getOpenId());
        }
        if(StringUtils.isNotBlank(signPage.getUserId())){
        	storeSignUp.setUserId(signPage.getUserId());
        }
        List<StoreSignUpDto> list = storeSignService.findSignList(storeSignUp);
        PageInfo<StoreSignUpDto> pageInfo = new PageInfo<StoreSignUpDto>(list);
        return  pageInfo;
    }
    
    private void sendMessage(StoreSignUp storeSignUp) {
		//loUjgu9Oner2Sy1USDwKk_CrY89_teWEsOesjNgMiHw
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" + AccessTokenUtil.accessToken.getAccess_token();
		WxTemplate temp = new WxTemplate();
		
		temp.setTouser(storeSignUp.getOpenId());
		temp.setForm_id(storeSignUp.getFormId());
		temp.setTemplate_id("3A7qbLZKs6-f4QN2oC30tX_ziHBEI6105__H6IcmLf8");
		Map<String, TemplateData> m = new HashMap<String, TemplateData>();
		TemplateData keyword1 = new TemplateData();
		keyword1.setColor("#000000");
		keyword1.setValue(storeSignUp.getUserName());
		m.put("keyword1", keyword1);
		
		TemplateData keyword2 = new TemplateData();
		keyword2.setColor("#000000");
		keyword2.setValue("通过");
		m.put("keyword2", keyword2);
		
		TemplateData keyword3 = new TemplateData();
		keyword3.setColor("#000000");
		keyword3.setValue("您的报名商家"+storeSignUp.getStoreName()+"已审核通过！");
		m.put("keyword3", keyword3);
		
		
		temp.setData(m);
		String jsonString = JSONObject.toJSONString(temp).toString();
		
		String result = HttpUtil.sendPost(url, jsonString);
		System.out.println(result); 
		
	}
}
