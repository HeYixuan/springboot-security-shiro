package org.springframe.mapper;

import org.springframe.domain.SystemResources;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

@Repository
public interface SystemResourcesMapper extends Mapper<SystemResources> {


    /**
     * 根据角色id查询资源
     * @param id
     * @return
     */
    public Collection<SystemResources> loadByRole(Integer id);


    /**
     * 根据父节点查询子节点
     * @param id
     * @return
     */
    public Collection<SystemResources> loadByParentId(Integer id);

    /**
     * 查询所有资源
     * @return
     */
    public Collection<SystemResources> getList();
}