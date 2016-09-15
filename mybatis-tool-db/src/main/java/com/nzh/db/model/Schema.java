package com.nzh.db.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class Schema {
    //驱动类
    private String driverClassName;
    //数据库连接Url
    private String url;
    //用户名
    private String username;
    //密码
    private String password;
    //读取属性文件初始化数据库连接对象
    public void init(){
        tableList.clear();
    }
    private List<Table> tableList=new ArrayList<Table>();
    public List<Table> getTableList(){
        return tableList;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
