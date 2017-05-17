package org.springframe.common.core;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframe.common.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * ServiceBase class
 *
 * @author: HeYixuan
 * @create: 2017-05-11 9:15
 */
public abstract class ServiceBase<T, MT extends Mapper<T>, DTO> implements IServiceBase<DTO> {

    /**
     * 受影响的行数断言
     */
    protected static class AffectedRows {
        private static int SingleOk = 1;

        /**
         * 单行受影响的行数断言
         *
         * @param
         * @return
         * @throws
         * @author: feng.yuan on 11/24/16
         */
        public static boolean singleOk(int affectedRows) {
            return affectedRows == SingleOk;
        }
    }

    @Autowired
    protected MT mapper;

    private Class<T> clz;
    private Class<DTO> dtoClass;

    protected ServiceBase() {
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        clz = (Class<T>) types[0];
        dtoClass = (Class<DTO>) types[2];
    }

    /**
     * DTO to Model
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 11/14/16
     */
    protected T toModel(DTO dto) throws Exception {
        T model = clz.newInstance();
        PropertyUtils.copyProperties(model, dto);
        return model;
    }

    /**
     * Model to DTO
     *
     * @param model
     * @return
     * @throws Exception
     */
    protected DTO toDto(T model) throws Exception {
        DTO dto = dtoClass.newInstance();
        PropertyUtils.copyProperties(dto, model);
        return dto;
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public int insert(DTO recordToInsert) throws Exception {
        return mapper.insert(toModel(recordToInsert));
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public int delete(DTO recordToDelete) throws Exception {
        return mapper.delete(toModel(recordToDelete));
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public int updateByPrimaryKey(DTO recordToUpdate) throws Exception {
        return mapper.updateByPrimaryKey(toModel(recordToUpdate));
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public List select(DTO record) throws Exception {
        return mapper.select(toModel(record));
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public List selectAll() throws Exception {
        return mapper.selectAll();
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public List selectByRowBounds(DTO record, Paging paging) throws Exception {
        return mapper.selectByRowBounds(toModel(record),
                paging == null ? PagingUtil.AllRows : PagingUtil.pageRows(paging.getPage(), paging.getRows()));
    }

    /**
     * Implement
     *
     * @param
     * @return
     * @throws
     * @author: feng.yuan on 10/26/16
     */
    public int selectCount(DTO record) throws Exception {
        return mapper.selectCount(toModel(record));
    }

    /**
     * HYX
     *
     * @param models
     * @throws Exception
     */
    protected void toDtoList(List<DTO> dtos, List<T> models) throws Exception {
        if (!models.isEmpty()) {
            for (T model : models) {
                dtos.add(toDto(model));
            }
        }
    }

}
