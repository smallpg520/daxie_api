package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.UserMapper;
import com.daxie.daxie_api.model.User;
import com.daxie.daxie_api.service.UserService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/09/02.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
