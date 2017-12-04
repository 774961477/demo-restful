package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StoreJoinDao;
import org.spring.springboot.dao.StoreSignUpDao;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.StoreSignUpDto;
import org.spring.springboot.service.StoreJoinService;
import org.spring.springboot.service.StoreSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StoreSignServiceImpl implements StoreSignService {

    @Autowired
    private StoreSignUpDao storeSignUpDao;

	@Override
	public List<StoreSignUpDto> findSignList(StoreSignUp storeSignUp) {
		return storeSignUpDao.findSignList(storeSignUp);
	}

	@Override
	public Long saveStoreSign(StoreSignUp storeSignUp) {
		return storeSignUpDao.saveStoreSign(storeSignUp);
	}
	@Override
	public Long editStoreSign(StoreSignUp storeSignUp) {
		return storeSignUpDao.editStoreSign(storeSignUp);
	}

	
	

    
}
