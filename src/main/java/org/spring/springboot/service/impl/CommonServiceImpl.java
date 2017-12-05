package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.CommonDao;
import org.spring.springboot.domain.Common;
import org.spring.springboot.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

	@Override
	public List<Common> findCommonList(Common common) {
		return commonDao.findCommonList(common);
	}

	@Override
	public Long saveCommon(Common common) {
		return commonDao.saveCommon(common);
	}

	@Override
	public Long deleteCommon(Common common) {
		return commonDao.deleteCommon(common);
	}

	
}
