package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Advertisement;
import org.spring.springboot.domain.AdvertisementDto;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface AdvertisementService {

    /**
     *  
     *
     * @return
     */
    List<AdvertisementDto> findAllAdvertisement();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    AdvertisementDto findAdvertisementById(String id);
    
    AdvertisementDto findByColumnId(String columnId);

    /**
     * 新增
     *
     * @param city
     * @return
     */
    Long saveAdvertisement(Advertisement advertisement);

    

    /**
     * 根据 ID,删除
     *
     * @param id
     * @return
     */
    Long deleteAdvertisement(String id);
}
