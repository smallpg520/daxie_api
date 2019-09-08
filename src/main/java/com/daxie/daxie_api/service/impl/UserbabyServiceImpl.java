package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.UserbabyMapper;
import com.daxie.daxie_api.model.Userbaby;
import com.daxie.daxie_api.service.UserbabyService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/08/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserbabyServiceImpl extends AbstractService<Userbaby> implements UserbabyService {
    @Resource
    private UserbabyMapper userbabyMapper;
}
