package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.CompanyJoin;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CompanyJoinDao {

    /**
     * 获取
     *
     * @return
     */
    List<CompanyJoin> findAllCompanyJoin();

    Long saveCompanyJoin(CompanyJoin companyJoin);
    Long editCompanyJoin(CompanyJoin companyJoin);
}
