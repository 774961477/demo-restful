package org.spring.springboot.dao;

import java.util.List;

import org.spring.springboot.domain.Common;
import org.spring.springboot.domain.Notice;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface NoticeDao {

    /**
     * 获取
     *
     * @return
     */
    List<Notice> findNoticeList();

    Long saveNotice(Notice notice);
    
    Long deleteNotice(Notice notice);
    
}
