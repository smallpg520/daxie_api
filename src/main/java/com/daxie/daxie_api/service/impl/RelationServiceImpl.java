package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.RelationMapper;
import com.daxie.daxie_api.model.Relation;
import com.daxie.daxie_api.service.RelationService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/01/23.
 */
@Service
@Transactional
public class RelationServiceImpl extends AbstractService<Relation> implements RelationService {
    @Resource
    private RelationMapper relationMapper;

}
