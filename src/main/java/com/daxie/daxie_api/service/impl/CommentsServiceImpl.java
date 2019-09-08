package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.CommentsMapper;
import com.daxie.daxie_api.model.Comments;
import com.daxie.daxie_api.service.CommentsService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/08/30.
 */
@Service
@Transactional
public class CommentsServiceImpl extends AbstractService<Comments> implements CommentsService {
    @Resource
    private CommentsMapper commentsMapper;

}
