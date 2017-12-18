package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.StationMessage;
import org.spring.springboot.domain.StationMessagePage;
import org.spring.springboot.domain.StoreDto;
import org.spring.springboot.service.StationMessageService;
import org.spring.springboot.service.StoreService;
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
@RequestMapping(value = "/stationmessage")
public class StationMessageController {

	@Autowired
	private StationMessageService stationMessageService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private IdGenerator idGenerator;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createMessage(@RequestBody StationMessage stationMessage) {
		stationMessage.setId(idGenerator.nextId());
		stationMessage.setState("X");
		
		
		StoreDto storeDto = storeService.findStoreById(stationMessage.getUserId());
		stationMessage.setUserId(storeDto.getCreateUserId());
		stationMessage.setUserName(storeDto.getStoreName());
		stationMessageService.saveMessage(stationMessage);
	}
	
	

	
	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<StationMessage> listPage(@RequestBody StationMessagePage messagePage) {
		PageHelper.startPage(messagePage.getPageNum(), messagePage.getPageSize());
		StationMessage stationMessage = new StationMessage();
		if(!"1".equals(messagePage.getUserId())){
			stationMessage.setUserId(messagePage.getUserId());
		}
		List<StationMessage> list = stationMessageService.findMessage(stationMessage);
		PageInfo<StationMessage> pageInfo = new PageInfo<StationMessage>(list);
		return pageInfo;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public StationMessage getMessageById(@RequestBody StationMessage message) {
		
		StationMessage stationMessage = new StationMessage();
		stationMessage = stationMessageService.getMessageById(message);
		if(!"1".equals(message.getUserId())){
			stationMessageService.editMessage(message);
		}
		return stationMessage;
	}

	
}
