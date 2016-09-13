package com.nzh.db;

import com.nzh.model.Schema;

import java.sql.*;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public abstract class QueryDb {
    private Schema schema;
    protected abstract void queryImpl(Connection con,PreparedStatement pre,ResultSet result) throws SQLException;
    public void query(Schema schema){
        this.schema=schema;
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName(this.schema.getDriverClassName());// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = this.schema.getUrl();// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = this.schema.getUsername();// 用户名,系统默认的账户名
            String password = this.schema.getPassword();// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            //String sql = "select * from student where name=?";// 预编译语句，“？”代表参数
            queryImpl(con,pre,result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
