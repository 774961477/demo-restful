package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Message;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;
import org.spring.springboot.domain.StoreJoin;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface MessageDao {

    /**
     * 获取
     *
     * @return
     */
    List<Message> findMessage(Message message);

    Long saveMessage(Message message);
    Long editMessage(Message message);
}
