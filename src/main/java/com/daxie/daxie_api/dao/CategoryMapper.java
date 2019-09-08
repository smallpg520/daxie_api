package com.daxie.daxie_api.dao;

import com.daxie.daxie_api.core.Mapper;
import com.daxie.daxie_api.model.Category;
import com.daxie.daxie_api.model.category.Cate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
// @Param("categoryprice") int price, @Param("categoryliren") int liren
// public  List<Category> selectBy(@Param("categorykind") String  kind, @Param("categorysales") String sales);

 public List<Category> hotcategory(@Param("categoryhot") Integer categoryhot);

 public   List<Category> vaguelike(@Param("categoryname") String categoryname,@Param("categorykind") String categorykind);

  public   List<Category> selectBy(Cate cate);
}