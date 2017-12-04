package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.Common;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CommonDao {

    /**
     * 获取
     *
     * @return
     */
    List<Common> findCommonList(Common common);

    Long saveCommon(Common common);
    
}
