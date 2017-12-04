package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.Column;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ColumnService {

    /**
     *  
     *
     * @return
     */
    List<Column> findAllColumn();
    
    List<Column> findColumnByParentId(Column column);

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    Column findColumnById(String id);

    /**
     * 新增
     *
     * @param city
     * @return
     */
    Long saveColumn(Column column);

    

    /**
     * 根据 ID,删除
     *
     * @param id
     * @return
     */
    Long deleteColumn(String id);
}
