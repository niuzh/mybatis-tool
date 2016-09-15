package com.nzh.db.service.impl;

import com.nzh.db.QueryDb;
import com.nzh.db.model.Column;
import com.nzh.db.model.Schema;
import com.nzh.db.service.IColumnService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class OracleColumnServiceImpl extends QueryDb implements IColumnService {
    String selectSql ="SELECT\n" +
            "  USER_TAB_COLUMNS.COLUMN_NAME,\n" +
            "  DATA_TYPE,\n" +
            "  DATA_LENGTH,\n" +
            "  NULLABLE,\n" +
            "  USER_COL_COMMENTS.COMMENTS,\n" +
            "  user_constraints.constraint_type\n" +
            "FROM USER_TAB_COLUMNS\n" +
            "  INNER JOIN USER_COL_COMMENTS ON (USER_TAB_COLUMNS.TABLE_NAME = USER_COL_COMMENTS.TABLE_NAME AND USER_TAB_COLUMNS.COLUMN_NAME = USER_COL_COMMENTS.COLUMN_NAME)\n" +
            "  LEFT JOIN user_cons_columns ON (user_cons_columns.TABLE_NAME = USER_COL_COMMENTS.TABLE_NAME AND user_cons_columns.COLUMN_NAME = USER_COL_COMMENTS.COLUMN_NAME)\n" +
            "  LEFT JOIN user_constraints ON (user_constraints.TABLE_NAME = USER_COL_COMMENTS.TABLE_NAME AND user_constraints.constraint_name = user_cons_columns.constraint_name)\n" +
            "WHERE USER_TAB_COLUMNS.TABLE_NAME = ?";
    private String tableName;
    public OracleColumnServiceImpl(String tableName){
        this.tableName=tableName;
    }
    private List<Column> columnList=new ArrayList<Column>();
    @Override
    protected void queryImpl(Connection con,PreparedStatement pre,ResultSet result) throws SQLException {
        columnList.clear();
        pre = con.prepareStatement(selectSql);// 实例化预编译语句
        pre.setString(1, tableName);// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next()) {
            String COLUMN_NAME=result.getString("COLUMN_NAME");
            String COMMENTS=result.getString("COMMENTS");
            String DATA_TYPE=result.getString("DATA_TYPE");
            String NULLABLE=result.getString("NULLABLE");
            String constraint_type=result.getString("constraint_type");
            System.out.println("name:" +COLUMN_NAME + " comments:" + COMMENTS);
            Column column=new Column();
            column.setName(COLUMN_NAME);
            column.setType(DATA_TYPE);
            column.setComments(COMMENTS);
            column.setConstraintType(constraint_type);
            column.setIsNullAble(NULLABLE.equals("Y"));
            addColumn(column);
        }
    }

    private void addColumn(Column column){
        if(column.getConstraintType()!=null&&column.getConstraintType().equals("P")){
            //为主键
            for (Column column1:columnList){
                if(column.getName().equals(column1.getName())){
                    column1.setConstraintType(column.getConstraintType());
                }
            }
        }else {
            columnList.add(column);
        }
    }

    public List<Column> findList(Schema schema) {
        this.query(schema);
        return columnList;
    }
}
