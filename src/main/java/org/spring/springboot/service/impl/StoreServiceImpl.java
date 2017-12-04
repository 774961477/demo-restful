package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StoreDao;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;
import org.spring.springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

	@Override
	public List<StoreDto> findAllStore(StoreDto storeDto) {
		// TODO Auto-generated method stub
		return storeDao.findAllStore(storeDto);
	}
	
	
	@Override
	public List<StoreDto> findStoreByColumnId(String columnId) {
		// TODO Auto-generated method stub
		return storeDao.findStoreByColumnId(columnId);
	}

	@Override
	public StoreDto findStoreById(String id) {
		// TODO Auto-generated method stub
		return storeDao.findById(id);
	}

	@Override
	public Long saveStore(Store store) {
		// TODO Auto-generated method stub
		return storeDao.saveStore(store);
	}
	@Override
	public Long editStore(Store store) {
		// TODO Auto-generated method stub
		return storeDao.editStore(store);
	}
	@Override
	public Long topStore(Store store) {
		// TODO Auto-generated method stub
		return storeDao.topStore(store);
	}
	@Override
	public Long deleteStore(String id) {
		// TODO Auto-generated method stub
		return storeDao.deleteStore(id);
	}

	@Override
	public Long updateStoreStars(Store store) {
		// TODO Auto-generated method stub
		return storeDao.updateStoreStars(store);
	}


	@Override
	public List<StoreDto> listPageForMobile(StoreDto storeDto) {
		// TODO Auto-generated method stub
		return storeDao.listPageForMobile(storeDto);
	}

	

    
}
