package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.Recruit;
import org.spring.springboot.domain.RecruitDto;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.service.RecruitService;
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
@RequestMapping(value = "/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createRecruit(@RequestBody Recruit recruit) {
    	recruit.setId(idGenerator.nextId());
    	recruitService.saveRecruit(recruit);
    }
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageInfo<RecruitDto> listPage(@RequestBody PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPageNum(), pageBounds.getPageSize());
        List<RecruitDto> list = recruitService.findRecruitList();
        PageInfo<RecruitDto> pageInfo = new PageInfo<RecruitDto>(list);
        return  pageInfo;
    }
}
