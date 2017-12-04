package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.StoreComment;
import org.spring.springboot.domain.StoreCommentDto;
import org.spring.springboot.domain.StoreJoin;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreCommentDao {

    /**
     * 获取
     *
     * @return
     */
    List<StoreCommentDto> findCommentByStoreId(StoreComment storeComment);

    Long saveStoreComment(StoreComment storeComment);
    
}
