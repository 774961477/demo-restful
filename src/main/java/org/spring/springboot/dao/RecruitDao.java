package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Recruit;
import org.spring.springboot.domain.RecruitDto;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface RecruitDao {

    /**
     * 获取
     *
     * @return
     */
    List<RecruitDto> findRecruitList();

    Long saveRecruit(Recruit recruit);
    
    RecruitDto findRecruitById(@Param("id") String id);
    
}
