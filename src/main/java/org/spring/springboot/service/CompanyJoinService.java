package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.CompanyJoin;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CompanyJoinService {

    /**
     *  
     *
     * @return
     */
    List<CompanyJoin> findAllCompanyJoin();

    Long saveCompanyJoin(CompanyJoin companyJoin);
    
    Long editCompanyJoin(CompanyJoin companyJoin);
    
}
