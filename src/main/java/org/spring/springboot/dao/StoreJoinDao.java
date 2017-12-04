package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;
import org.spring.springboot.domain.StoreJoin;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreJoinDao {

    /**
     * 获取
     *
     * @return
     */
    List<StoreJoin> findAllStoreJoin();

    Long saveStoreJoin(StoreJoin storeJoin);
    Long editStoreJoin(StoreJoin storeJoin);
}
