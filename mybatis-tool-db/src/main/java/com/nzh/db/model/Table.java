package com.nzh.db.model;

import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class Table {
    //名称
    private String name;
    //备注
    private String comments;
    //主键列集合
    private List<Column> columnKeyList;
    //列集合
    private List<Column> columnList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Column> getColumnKeyList() {
        return columnKeyList;
    }

    public void setColumnKeyList(List<Column> columnKeyList) {
        this.columnKeyList = columnKeyList;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }
}
