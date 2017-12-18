package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Message;
import org.spring.springboot.domain.StationMessage;

/**
 *
 */
public interface StationMessageService {

	List<StationMessage> findMessage(StationMessage stationMessage);

	Long saveMessage(StationMessage stationMessage);

	StationMessage getMessageById(StationMessage stationMessage);
	
	Long editMessage(StationMessage stationMessage);

}
