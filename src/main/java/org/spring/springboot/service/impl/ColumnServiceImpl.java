package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.ColumnDao;
import org.spring.springboot.domain.Column;
import org.spring.springboot.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnDao columnDao;

	@Override
	public List<Column> findAllColumn() {
		// TODO Auto-generated method stub
		return columnDao.findAllColumn();
	}
	@Override
	public List<Column> findColumnByParentId(Column column) {
		// TODO Auto-generated method stub
		return columnDao.findColumnByParentId(column);
	}

	@Override
	public Column findColumnById(String id) {
		// TODO Auto-generated method stub
		return columnDao.findById(id);
	}

	@Override
	public Long saveColumn(Column column) {
		// TODO Auto-generated method stub
		return columnDao.saveColumn(column);
	}

	@Override
	public Long deleteColumn(String id) {
		// TODO Auto-generated method stub
		return columnDao.deleteColumn(id);
	}

    
}
