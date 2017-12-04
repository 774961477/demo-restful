package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Column;
import org.spring.springboot.domain.PageColumn;
import org.spring.springboot.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createColumn(@RequestBody Column column) {
    	column.setId(idGenerator.nextId());
    	columnService.saveColumn(column);
    }
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public List<Column> listPage(@RequestBody Column column) {
        List<Column> list = columnService.findColumnByParentId(column);
        return  list;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Column> listColumn() {
    	
    	return columnService.findAllColumn();
    }
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Column findById(@RequestBody Column column) {
    	
    	return columnService.findColumnById(column.getId());
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteColumn(@RequestBody Column column) {
    	columnService.deleteColumn(column.getId());
    }

    
}
