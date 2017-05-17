package org.springframe.system.service;

import org.springframe.common.core.Pagination;
import org.springframe.domain.SystemUser;

/**
 * @author: HeYixuan
 * @create: 2017-05-15 9:50
 */
public interface ISystemUserService {

    public Pagination<SystemUser> getList(int pageSi);
}
