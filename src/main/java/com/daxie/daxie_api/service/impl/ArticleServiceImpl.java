package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.dao.ArticleMapper;
import com.daxie.daxie_api.model.Article;
import com.daxie.daxie_api.service.ArticleService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 代码生成器 on 2019/09/05.
 */
@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

}
