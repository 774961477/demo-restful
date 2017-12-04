package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.StoreJoin;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreJoinService {

    /**
     *  
     *
     * @return
     */
    List<StoreJoin> findAllStoreJoin();

    Long saveStoreJoin(StoreJoin storeJoin);
    
    Long editStoreJoin(StoreJoin storeJoin);
    
}
