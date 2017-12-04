package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.StoreSignUpDto;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StoreSignService {

    /**
     *  
     *
     * @return
     */
    List<StoreSignUpDto> findSignList(StoreSignUp storeSignUp);

    Long saveStoreSign(StoreSignUp storeSignUp);
    Long editStoreSign(StoreSignUp storeSignUp);
    
}
