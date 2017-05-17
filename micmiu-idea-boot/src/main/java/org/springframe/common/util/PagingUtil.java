package org.springframe.common.util;

import org.springframe.common.core.Paging;
import org.apache.ibatis.session.RowBounds;

/**
 * PagingUtil class
 *
 * @author: HeYixuan
 * @create: 2017-05-11 9:15
 */
public final class PagingUtil {

    public static final RowBounds AllRows = new RowBounds();

    /**
     * 分页参数
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     * @history feng.yuan 2016/11/17 <comment>fix incorrect pagination</comment>
     */
    public static RowBounds pageRows(int page, int rows) {
        return new RowBounds((page - 1) * rows, rows);
    }

    /**
     * 分页参数
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    public static RowBounds pageRows(Paging paging) {
        return paging == null ? PagingUtil.AllRows : PagingUtil.pageRows(paging.getPage(), paging.getRows());
    }
}
