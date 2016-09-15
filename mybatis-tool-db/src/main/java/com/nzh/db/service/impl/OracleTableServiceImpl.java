package com.nzh.db.service.impl;

import com.nzh.db.model.Schema;
import com.nzh.db.model.Table;
import com.nzh.db.service.ITableService;
import com.nzh.db.QueryDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class OracleTableServiceImpl extends QueryDb implements ITableService {
    String selectTable="select table_name as name,Comments as comments from user_tab_comments";
    private List<Table> tableList=new ArrayList<Table>();
    @Override
    protected void queryImpl(Connection con,PreparedStatement pre,ResultSet result) throws SQLException {
        tableList.clear();
        String sql=selectTable;
        pre = con.prepareStatement(sql);// 实例化预编译语句
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next()) {
            String name=result.getString("name");
            String comments=result.getString("comments");
            System.out.println("name:" + result.getString("name") + " comments:"
                    + result.getString("comments"));
            Table table=new Table();
            table.setName(name);
            table.setComments(comments);
            tableList.add(table);
        }
    }

    public List<Table> findList(Schema schema) {
        this.query(schema);
        return tableList;
    }
}
