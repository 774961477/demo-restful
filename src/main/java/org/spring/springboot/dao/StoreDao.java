package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreDao {

    /**
     * 获取
     *
     * @return
     */
    List<StoreDto> findAllStore(StoreDto storeDto);
    List<StoreDto> listPageForMobile(StoreDto storeDto);
    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    StoreDto findById(@Param("id") String id);

    Long saveStore(Store store);
    
    Long editStore(Store store);
    
    Long topStore(Store store); 
    
    Long updateStoreStars(Store store);

    Long deleteStore(String id);
    
    List<StoreDto> findStoreByColumnId(@Param("columnId") String columnId);
}
