package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.StoreComment;
import org.spring.springboot.domain.StoreCommentDto;
import org.spring.springboot.domain.StoreJoin;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreCommentService {

    /**
     *  
     *
     * @return
     */
	 List<StoreCommentDto> findCommentByStoreId(StoreComment storeComment);

	 Long saveStoreComment(StoreComment storeComment);
    
}
