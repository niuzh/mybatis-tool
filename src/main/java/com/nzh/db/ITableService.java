package com.nzh.db;

import com.nzh.model.Schema;
import com.nzh.model.Table;

import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public interface ITableService {
    List<Table> findList(Schema schema);
}
