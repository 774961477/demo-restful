package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.StationMessage;

/**
 */
public interface StationMessageDao {

    /**
     * 获取
     *
     * @return
     */
    List<StationMessage> findMessage(StationMessage stationMessage);
    Long saveMessage(StationMessage stationMessage);
    StationMessage getMessageById(StationMessage stationMessage);
    
    Long editMessage(StationMessage stationMessage);
}
