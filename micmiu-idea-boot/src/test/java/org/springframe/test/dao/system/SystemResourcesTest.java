package org.springframe.test.dao.system;

import org.junit.Test;
import org.springframe.BaseTest;
import org.springframe.domain.SystemResources;
import org.springframe.domain.SystemRole;
import org.springframe.mapper.SystemResourcesMapper;
import org.springframe.mapper.SystemRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 9:03
 */
public class SystemResourcesTest extends BaseTest {

    @Autowired
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemResourcesMapper systemResourcesMapper;

    @Test
    public void loadByRole(){
        Collection<SystemRole> roles = systemRoleMapper.loadByUser(1);
        roles.forEach( role -> {
            Collection<SystemResources> resources = systemResourcesMapper.loadByRole(role.getId());
            System.err.print("集合: " +resources.size());
            resources.forEach( r -> {
                System.err.println("资源id：" + r.getId() + " 资源名称：" + r.getName() + " 资源权限：" + r.getAuthc() + " 资源路径：" +r.getUrl());
            });
        });
    }

    @Test
    public void loadByParentId(){
        Collection<SystemResources> resources = systemResourcesMapper.loadByParentId(2);
        resources.forEach( r -> {
            System.err.println("资源id：" + r.getId() + " 资源名称：" + r.getName() + " 资源权限：" + r.getAuthc() + " 资源路径：" +r.getUrl());
        });
    }

    @Test
    public void getList(){
        Collection<SystemResources> resources = systemResourcesMapper.getList();
        resources.forEach( r -> {
            System.err.println(" 资源权限：" + r.getAuthc() + " 资源路径：" +r.getUrl());
        });
    }
}
