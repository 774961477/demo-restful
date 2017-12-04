package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Message;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface MessageService {

    /**
     *  
     *
     * @return
     */
    List<Message> findMessage(Message message);

    Long saveMessage(Message message);
    
    Long editMessage(Message message);
    
}
