package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Common;
import org.spring.springboot.domain.CommonPage;
import org.spring.springboot.domain.Message;
import org.spring.springboot.service.CommonService;
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
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createCommon(@RequestBody Common common) {
    	common.setId(idGenerator.nextId());
    	common.setCode(common.getId());
    	commonService.saveCommon(common);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Common> search(@RequestBody Common common) {
        List<Common> list = commonService.findCommonList(common);
       
        return  list;
    }
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<Common> listPage(@RequestBody CommonPage commonPage) {
		PageHelper.startPage(commonPage.getPageNum(), commonPage.getPageSize());
		Common common = new Common();
		common.setType(commonPage.getType());
		List<Common> list = commonService.findCommonList(common);
		PageInfo<Common> pageInfo = new PageInfo<Common>(list);
		return pageInfo;
	}
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Common common) {
		
		 commonService.deleteCommon(common);
		
	}
}
