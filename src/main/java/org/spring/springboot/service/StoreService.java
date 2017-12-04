package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Column;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreService {

    /**
     *  
     *
     * @return
     */
    List<StoreDto> findAllStore(StoreDto storeDto);
    
    List<StoreDto> listPageForMobile(StoreDto storeDto);

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    StoreDto findStoreById(String id);

    /**
     * 新增
     *
     * @param city
     * @return
     */
    Long saveStore(Store store);
    
    Long topStore(Store store);
    
    Long editStore(Store store);
    
    Long updateStoreStars(Store store);

    

    /**
     * 根据 ID,删除
     *
     * @param id
     * @return
     */
    Long deleteStore(String id);
    
    List<StoreDto> findStoreByColumnId(String columnId);
}
