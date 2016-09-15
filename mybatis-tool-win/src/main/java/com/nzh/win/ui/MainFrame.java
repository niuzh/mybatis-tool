package com.nzh.win.ui;

import com.nzh.db.model.Column;
import com.nzh.db.model.Schema;
import com.nzh.db.model.Table;
import com.nzh.db.service.ISchemaService;
import com.nzh.db.service.impl.OracleSchemaServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author zhihuan.niu on 2016/9/12.
 */
public class MainFrame extends JFrame implements ActionListener {
    private Schema schema;
    private String dbType;
    private ISchemaService schemaService;
    private List<Table> tableList;
    public MainFrame(){
        //设置高宽
        setBounds(300, 300, 300, 300);
        //退出控制按钮
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //可见
        setVisible(true);
        //布局方式
        setLayout(null);
        loadProperties();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
    }

    private void loadProperties() {
        //读取属性文件
        Properties properties=new Properties();
        InputStream in=Object.class.getResourceAsStream("/app.properties");
        try{
            properties.load(in);
        } catch (IOException e1){
            e1.printStackTrace();
        }
        schema=new Schema();
        dbType=properties.getProperty("dbType");
        schema.setDriverClassName(properties.getProperty("driverClassName").trim());
        schema.setUrl(properties.getProperty("url").trim());
        schema.setUsername(properties.getProperty("username").trim());
        schema.setPassword(properties.getProperty("password").trim());
        if(dbType.equals("oracle")){
            schemaService=new OracleSchemaServiceImpl(schema);
        }
        tableList=schemaService.findTableList();
    }
}
