package com.nzh.win.model;

import com.nzh.db.model.Table;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public class TableDto extends Table{
    public TableDto(Table table){
        setName(table.getName());
    }
    //过滤字段 如 fix fib ppm
    private String pre;

    /**
     * 返回转行后的名字
     * @return FIB_INCREMENT>Increment
     */
    public String getDtoName(){
        //FIB_INCREMENT
        return "Increment";
    }

}
