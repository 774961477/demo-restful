package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.MessageDao;
import org.spring.springboot.domain.Message;
import org.spring.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

	@Override
	public List<Message> findMessage(Message message) {
		return messageDao.findMessage(message);
	}

	@Override
	public Long saveMessage(Message message) {
		return messageDao.saveMessage(message);
	}

	@Override
	public Long editMessage(Message message) {
		return messageDao.editMessage(message);
	}

	
    
}
