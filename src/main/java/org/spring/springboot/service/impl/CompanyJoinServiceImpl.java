package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.CompanyJoinDao;
import org.spring.springboot.domain.CompanyJoin;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.service.CompanyJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CompanyJoinServiceImpl implements CompanyJoinService {

    @Autowired
    private CompanyJoinDao companyJoinDao;

	@Override
	public List<CompanyJoin> findAllCompanyJoin() {
		return companyJoinDao.findAllCompanyJoin();
	}

	@Override
	public Long saveCompanyJoin(CompanyJoin companyJoin) {
		return companyJoinDao.saveCompanyJoin(companyJoin);
	}
	@Override
	public Long editCompanyJoin(CompanyJoin companyJoin) {
		return companyJoinDao.editCompanyJoin(companyJoin);
	}
	
	

    
}
