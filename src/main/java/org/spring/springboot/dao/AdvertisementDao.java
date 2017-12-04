package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Advertisement;
import org.spring.springboot.domain.AdvertisementDto;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface AdvertisementDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<AdvertisementDto> findAllAdvertisement();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    AdvertisementDto findById(@Param("id") String id);
    
    AdvertisementDto findByColumnId(@Param("columnId") String columnId);

    Long saveAdvertisement(Advertisement advertisement);

    

    Long deleteAdvertisement(String id);
}
