package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Column;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ColumnDao {

    /**
     * 获取
     *
     * @return
     */
    List<Column> findAllColumn();
    List<Column> findColumnByParentId(Column column);
    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    Column findById(@Param("id") String id);

    Long saveColumn(Column column);

    Long deleteColumn(String id);
}
