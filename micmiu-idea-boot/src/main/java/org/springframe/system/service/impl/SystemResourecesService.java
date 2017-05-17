package org.springframe.system.service.impl;

import org.springframe.domain.SystemResources;
import org.springframe.mapper.SystemResourcesMapper;
import org.springframe.system.service.ISystemResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-12 12:17
 */
@Service
public class SystemResourecesService implements ISystemResourcesService {
    @Autowired
    private SystemResourcesMapper systemResourcesMapper;

    @Override
    public Collection<SystemResources> getList() {
        return systemResourcesMapper.getList();
    }
}
