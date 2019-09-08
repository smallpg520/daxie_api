package com.daxie.daxie_api.service.impl;

import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.dao.CategoryMapper;
import com.daxie.daxie_api.model.Category;
import com.daxie.daxie_api.model.category.Cate;
import com.daxie.daxie_api.service.CategoryService;
import com.daxie.daxie_api.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 代码生成器 on 2019/09/03.
 */
@Service
@Transactional
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> select(Cate cate){

        return  categoryMapper.selectBy(cate);
    }
    @Override
    public List<Category> hotcategory(Integer categoryhot){
        if (categoryhot ==null){
        return (List<Category>) ResultGenerator.genFailResult("前端数据没有传值");
        }

        return categoryMapper.hotcategory(categoryhot);
    }
    @Override
    public   List<Category> vaguelike(String categoryname,String categorykind){

        return categoryMapper.vaguelike(categoryname,categorykind);
    }

}
