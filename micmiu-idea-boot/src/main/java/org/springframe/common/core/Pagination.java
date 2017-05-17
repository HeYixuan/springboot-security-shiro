package org.springframe.common.core;

import java.util.List;

/**
 * @author: HeYixuan
 * @create: 2017-05-11 9:15
 */
public class Pagination<T> {

    private List<T> rows;
    private Integer total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static Pagination create(List rows, Integer total) {
        Pagination pagination = new Pagination();
        pagination.setRows(rows);
        pagination.setTotal(total);
        return pagination;
    }
}
