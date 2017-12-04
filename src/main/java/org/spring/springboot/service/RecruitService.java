package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Recruit;
import org.spring.springboot.domain.RecruitDto;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface RecruitService {

    /**
     *  
     *
     * @return
     */
    List<RecruitDto> findRecruitList();

    Long saveRecruit(Recruit recruit);
    
}
