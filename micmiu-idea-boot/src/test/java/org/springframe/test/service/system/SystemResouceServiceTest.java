package org.springframe.test.service.system;

import org.junit.Test;
import org.springframe.BaseTest;
import org.springframe.domain.SystemResources;
import org.springframe.mapper.SystemResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 12:20
 */
public class SystemResouceServiceTest extends BaseTest {

    @Autowired
    private SystemResourcesMapper systemResourcesMapper;

    @Test
    public void getList(){
        Collection<SystemResources> resources = systemResourcesMapper.getList();
        resources.forEach( r -> {
            System.err.println("资源id：" + r.getId() + " 资源名称：" + r.getName() + " 资源权限：" + r.getAuthc() + " 资源路径：" +r.getUrl());
        });
    }
}
