package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.NoticeDao;
import org.spring.springboot.domain.Notice;
import org.spring.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

	@Override
	public List<Notice> findNoticeList() {
		return noticeDao.findNoticeList();
	}

	@Override
	public Long saveNotice(Notice notice) {
		return noticeDao.saveNotice(notice);
	}

	@Override
	public Long deleteNotice(Notice notice) {
		return noticeDao.deleteNotice(notice);
	}

	
}
