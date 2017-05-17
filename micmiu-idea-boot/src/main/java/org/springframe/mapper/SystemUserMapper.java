package org.springframe.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframe.common.util.Page;
import org.springframe.domain.SystemUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface SystemUserMapper extends Mapper<SystemUser> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public SystemUser loadByUsername(String username);

    /**
     * 查询集合
     * @param systemUser
     * @return
     */
    public List<SystemUser> getList(SystemUser systemUser, RowBounds rowBounds);
}