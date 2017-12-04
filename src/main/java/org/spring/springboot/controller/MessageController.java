package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Message;
import org.spring.springboot.domain.MessagePage;
import org.spring.springboot.service.MessageService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(value = "/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private IdGenerator idGenerator;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void createMessage(@RequestBody Message message) {
		message.setId(idGenerator.nextId());
		message.setFlag("Q");
		messageService.saveMessage(message);
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public void replyMessage(@RequestBody Message message) {
		Message replyMessage = new Message();
		BeanUtils.copyProperties(message, replyMessage);
		String replyId = idGenerator.nextId();
		replyMessage.setId(replyId);
		replyMessage.setFlag("A");
		message.setReplyId(replyId);
		messageService.editMessage(message);
		messageService.saveMessage(replyMessage);
	}

	
	@RequestMapping(value = "/listPage", method = RequestMethod.POST)
	public PageInfo<Message> listPage(@RequestBody MessagePage messagePage) {
		PageHelper.startPage(messagePage.getPageNum(), messagePage.getPageSize());
		Message message = new Message();
		message.setOpenId(messagePage.getOpenId());
		List<Message> list = messageService.findMessage(message);
		PageInfo<Message> pageInfo = new PageInfo<Message>(list);
		return pageInfo;
	}

	
}
