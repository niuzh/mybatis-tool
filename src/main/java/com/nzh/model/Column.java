package com.nzh.model;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class Column {
    //名称
    private String name;
    //备注
    private String comments;
    //类型
    private String type;
    //主外健
    private String constraintType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConstraintType() {
        return constraintType;
    }

    public void setConstraintType(String constraintType) {
        this.constraintType = constraintType;
    }
}
