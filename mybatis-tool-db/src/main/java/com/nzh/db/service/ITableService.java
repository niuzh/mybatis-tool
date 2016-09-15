package com.nzh.db.service;

import com.nzh.db.model.Schema;
import com.nzh.db.model.Table;

import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public interface ITableService {
    List<Table> findList(Schema schema);
}
