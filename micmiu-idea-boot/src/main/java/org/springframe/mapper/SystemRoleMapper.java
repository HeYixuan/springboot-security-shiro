package org.springframe.mapper;

import org.springframe.domain.SystemRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;

@Repository
public interface SystemRoleMapper extends Mapper<SystemRole> {

    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    public Collection<SystemRole> loadByUser(Integer id);
}