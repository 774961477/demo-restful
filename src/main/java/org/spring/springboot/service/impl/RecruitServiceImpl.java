package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.RecruitDao;
import org.spring.springboot.domain.Recruit;
import org.spring.springboot.domain.RecruitDto;
import org.spring.springboot.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class RecruitServiceImpl implements RecruitService {
	@Autowired
    private RecruitDao recruitDao;
	@Override
	public List<RecruitDto> findRecruitList() {
		// TODO Auto-generated method stub
		return recruitDao.findRecruitList();
	}

	@Override
	public Long saveRecruit(Recruit recruit) {
		// TODO Auto-generated method stub
		return recruitDao.saveRecruit(recruit);
	}
	@Override
	public RecruitDto findRecruitById(String id) {
		// TODO Auto-generated method stub
		return recruitDao.findRecruitById(id);
	}
    
	
	
}
