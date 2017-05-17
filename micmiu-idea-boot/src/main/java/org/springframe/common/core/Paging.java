package org.springframe.common.core;

/**
 * Paging class
 *
 * @author: HeYixuan
 * @create: 2017-05-11 9:15
 */
public final class Paging {

    private Integer page;
    private Integer rows;

    /**
     * private ctor
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    public Paging() {
    }

    /**
     * ctor
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/14/16
     */
    public Paging(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * 自定义无依赖的分页参数
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/14/16
     */
    public static Paging paging(int page, int rows) {
        return new Paging(page, rows);
    }
}
