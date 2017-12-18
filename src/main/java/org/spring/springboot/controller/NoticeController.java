package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Common;
import org.spring.springboot.domain.CommonPage;
import org.spring.springboot.domain.Notice;
import org.spring.springboot.service.NoticeService;
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
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createNotice(@RequestBody Notice notice) {
    	notice.setId(idGenerator.nextId());
    	noticeService.saveNotice(notice);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Notice> list() {
        List<Notice> list = noticeService.findNoticeList();
       
        return  list;
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Notice get(@RequestBody Notice notice) {
        Notice notice2 = noticeService.findNoticeById(notice);
       
        return  notice2;
    }
    
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Notice notice) {
		
    	noticeService.deleteNotice(notice);
		
	}
}
