package com.nzh.db.service.impl;

import com.nzh.db.model.Column;
import com.nzh.db.model.Schema;
import com.nzh.db.model.Table;
import com.nzh.db.service.ISchemaService;

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
        return new OracleColumnServiceImpl(tableName).findList(schema);
    }
}
