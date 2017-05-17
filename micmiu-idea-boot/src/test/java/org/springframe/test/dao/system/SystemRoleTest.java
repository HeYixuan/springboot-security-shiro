package org.springframe.test.dao.system;

import org.junit.Test;
import org.springframe.BaseTest;
import org.springframe.domain.SystemRole;
import org.springframe.domain.SystemUser;
import org.springframe.mapper.SystemRoleMapper;
import org.springframe.mapper.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 8:43
 */
public class SystemRoleTest extends BaseTest {

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Test
    public void loadByUser(){
        SystemUser systemUser = systemUserMapper.loadByUsername("admin");
        if ( !StringUtils.isEmpty(systemUser) ){
            Collection<SystemRole> roles = systemRoleMapper.loadByUser(systemUser.getId());
            if ( !CollectionUtils.isEmpty(roles) ){
                roles.forEach( role -> {
                    System.err.print("角色名称：" + role.getName());
                });
            }
        }
    }

}
