package org.springframe.test.dao.system;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframe.BaseTest;
import org.springframe.common.core.Paging;
import org.springframe.common.util.Page;
import org.springframe.common.util.PagingUtil;
import org.springframe.common.util.PasswordHelper;
import org.springframe.domain.SystemUser;
import org.springframe.mapper.SystemUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;

import java.util.List;

/**
 * @author: HeYixuan
 * @create: 2017-05-11 10:33
 */
public class SystemUserTest extends BaseTest {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Test
    public void loadByUsername(){
       SystemUser systemUser =  systemUserMapper.loadByUsername("admin");
       System.err.print(systemUser.getUsername());
    }

    @Test
    public void getList(){
    }
}
