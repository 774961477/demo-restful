package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Notice;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface NoticeService {

    /**
     *  
     *
     * @return
     */
    List<Notice> findNoticeList();
    
    Notice findNoticeById(Notice notice);

    Long saveNotice(Notice notice);
    
    Long deleteNotice(Notice notice);
    
}
