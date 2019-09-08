package com.daxie.daxie_api.service;
import com.daxie.daxie_api.model.Category;
import com.daxie.daxie_api.core.Service;
import com.daxie.daxie_api.model.category.Cate;

import java.util.List;


/**
 * Created by 代码生成器 on 2019/09/03.
 */
public interface CategoryService extends Service<Category> {

 public List<Category> select(Cate cate);

 public List<Category> hotcategory(Integer categoryhot);

 public List<Category> vaguelike(String categoryname, String categorykind);
}
