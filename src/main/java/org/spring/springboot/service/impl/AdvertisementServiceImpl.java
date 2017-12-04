package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.AdvertisementDao;
import org.spring.springboot.domain.Advertisement;
import org.spring.springboot.domain.AdvertisementDto;
import org.spring.springboot.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

	@Override
	public List<AdvertisementDto> findAllAdvertisement() {
		// TODO Auto-generated method stub
		return advertisementDao.findAllAdvertisement();
	}

	@Override
	public AdvertisementDto findAdvertisementById(String id) {
		// TODO Auto-generated method stub
		return advertisementDao.findById(id);
	}
	
	@Override
	public AdvertisementDto findByColumnId(String columnId) {
		// TODO Auto-generated method stub
		return advertisementDao.findByColumnId(columnId);
	}

	@Override
	public Long saveAdvertisement(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return advertisementDao.saveAdvertisement(advertisement);
	}

	@Override
	public Long deleteAdvertisement(String id) {
		// TODO Auto-generated method stub
		return advertisementDao.deleteAdvertisement(id);
	}

    

}
