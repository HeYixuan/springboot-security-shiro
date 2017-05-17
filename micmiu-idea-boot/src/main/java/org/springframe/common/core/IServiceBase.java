package org.springframe.common.core;

import java.util.List;

/**
 * IServiceBase class
 * 该类提供service层常用的方法, 直接继承
 *
 * @author: HeYixuan
 * @create: 2017-05-11 9:15
 */
public interface IServiceBase<DTO> {

    /**
     * 新增单表记录
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    int insert(DTO recordToInsert) throws Exception;

    /**
     * 删除单表记录(物理)
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    int delete(DTO recordToDelete) throws Exception;

    /**
     * 按主键更新单表记录
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    int updateByPrimaryKey(DTO recordToUpdate) throws Exception;

    /**
     * 查询单表记录, 支持单表精确字段查询
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    List select(DTO record) throws Exception;

    /**
     * 查询单表所有记录
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    List selectAll() throws Exception;

    /**
     * 分页查找, 支持单表精确字段查询
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    List selectByRowBounds(DTO record, Paging paging) throws Exception;

    /**
     * 取记录数
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/10/16
     */
    int selectCount(DTO record) throws Exception;
}
