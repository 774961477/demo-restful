package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StationMessageDao;
import org.spring.springboot.domain.Message;
import org.spring.springboot.domain.StationMessage;
import org.spring.springboot.service.StationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StationMessageServiceImpl implements StationMessageService {

    @Autowired
    private StationMessageDao stationMessageDao;

	@Override
	public List<StationMessage> findMessage(StationMessage stationMessage) {
		return stationMessageDao.findMessage(stationMessage);
	}

	@Override
	public Long saveMessage(StationMessage stationMessage) {
		return stationMessageDao.saveMessage(stationMessage);
	}
	
	@Override
	public Long editMessage(StationMessage stationMessage) {
		return stationMessageDao.editMessage(stationMessage);
	}

	@Override
	public StationMessage getMessageById(StationMessage stationMessage) {
		return stationMessageDao.getMessageById(stationMessage);
	}

	
    
}
