package org.springframe.system.service;

import org.springframe.domain.SystemResources;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 12:08
 */
public interface ISystemResourcesService {
    /**
     * 查询所有资源
     * @return
     */
    public Collection<SystemResources> getList();
}
