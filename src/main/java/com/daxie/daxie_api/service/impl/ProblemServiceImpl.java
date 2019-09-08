package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.ProblemMapper;
import com.daxie.daxie_api.model.Problem;
import com.daxie.daxie_api.service.ProblemService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/01/22.
 */
@Service
@Transactional
public class ProblemServiceImpl extends AbstractService<Problem> implements ProblemService {
    @Resource
    private ProblemMapper problemMapper;

}
