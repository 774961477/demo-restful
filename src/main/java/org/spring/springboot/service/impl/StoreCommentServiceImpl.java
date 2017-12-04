package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StoreCommentDao;
import org.spring.springboot.domain.StoreComment;
import org.spring.springboot.domain.StoreCommentDto;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.service.StoreCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StoreCommentServiceImpl implements StoreCommentService{

    @Autowired
    private StoreCommentDao storeCommentDao;

	@Override
	public List<StoreCommentDto> findCommentByStoreId(StoreComment storeComment) {
		// TODO Auto-generated method stub
		return storeCommentDao.findCommentByStoreId(storeComment);
	}

	@Override
	public Long saveStoreComment(StoreComment storeComment) {
		// TODO Auto-generated method stub
		return storeCommentDao.saveStoreComment(storeComment);
	}

	
}
