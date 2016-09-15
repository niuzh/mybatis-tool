package com.nzh.db.service;


import com.nzh.db.model.Column;
import com.nzh.db.model.Schema;

import java.util.List;

/**
 * @author zhihuan.niu on 2016/9/13.
 */
public interface IColumnService {
    List<Column> findList(Schema schema);
}
