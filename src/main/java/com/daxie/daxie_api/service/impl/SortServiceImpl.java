package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.SortMapper;
import com.daxie.daxie_api.model.Sort;
import com.daxie.daxie_api.service.SortService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/01/21.
 */
@Service
@Transactional
public class SortServiceImpl extends AbstractService<Sort> implements SortService {
    @Resource
    private SortMapper sortMapper;

}
