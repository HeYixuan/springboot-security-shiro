package org.springframe.system.web;

import org.springframe.common.util.Page;
import org.springframe.common.util.PagingUtil;
import org.springframe.domain.SystemUser;
import org.springframe.mapper.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author: HeYixuan
 * @create: 2017-05-15 9:44
 */
@Controller
@RequestMapping("/systemUser")
public class SystemUserController {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @RequestMapping(value = "manage", method = RequestMethod.GET)
    public String manage(){
        return "systemUser/manage";
    }

    @RequestMapping(value = "getList", method = RequestMethod.POST)
    public Page<SystemUser> list(SystemUser systemUser, int page, int rows){
        List<SystemUser> userList =  systemUserMapper.getList(systemUser, PagingUtil.pageRows(1,5));
        Page<SystemUser> pageList = new Page<SystemUser>();
        pageList.setRows(userList);
        System.err.println(page);
        return pageList;
    }
}
