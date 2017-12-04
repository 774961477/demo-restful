package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Common;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CommonService {

    /**
     *  
     *
     * @return
     */
    List<Common> findCommonList(Common common);

    Long saveCommon(Common common);
    
}
