package com.nzh.db;

import com.nzh.model.Column;
import com.nzh.model.Table;

import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public interface ISchemaService {
    String selectTable="";
    /**
     * 查询数据库表
     * @return
     */
    List<Table> findTableList();

    /**
     * 根据表名返回表的列集合
     * @param tableName
     * @return
     */
    List<Column> findColumnByTableName(String tableName);
}
