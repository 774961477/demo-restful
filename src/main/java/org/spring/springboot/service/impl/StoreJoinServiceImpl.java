package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StoreJoinDao;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.service.StoreJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StoreJoinServiceImpl implements StoreJoinService {

    @Autowired
    private StoreJoinDao storeJoinDao;

	@Override
	public List<StoreJoin> findAllStoreJoin() {
		return storeJoinDao.findAllStoreJoin();
	}

	@Override
	public Long saveStoreJoin(StoreJoin storeJoin) {
		return storeJoinDao.saveStoreJoin(storeJoin);
	}
	@Override
	public Long editStoreJoin(StoreJoin storeJoin) {
		return storeJoinDao.editStoreJoin(storeJoin);
	}
	
	

    
}
