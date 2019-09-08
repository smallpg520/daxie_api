package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.ReplyMapper;
import com.daxie.daxie_api.model.Reply;
import com.daxie.daxie_api.service.ReplyService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/01/22.
 */
@Service
@Transactional
public class ReplyServiceImpl extends AbstractService<Reply> implements ReplyService {
    @Resource
    private ReplyMapper replyMapper;

}
