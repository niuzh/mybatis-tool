package com.nzh.db.impl;

import com.nzh.db.ISchemaService;
import com.nzh.model.Column;
import com.nzh.model.Schema;
import com.nzh.model.Table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class OracleSchemaServiceImpl implements ISchemaService {
    private Schema schema;
    public OracleSchemaServiceImpl(Schema schema){
        this.schema=schema;
    }

    /**
     * 查询数据库表
     *
     * @return
     */
    public List<Table> findTableList() {
        List<Table> tableList=new OracleTableServiceImpl().findList(schema);
        return tableList;
    }

    /**
     * 根据表名返回表的列集合
     *
     * @param tableName
     * @return
     */
    public List<Column> findColumnByTableName(String tableName) {
        return null;
    }
}
