package com.daxie.daxie_api.controller;
import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.model.Category;
import com.daxie.daxie_api.model.category.Cate;
import com.daxie.daxie_api.model.category.Requetvo;
import com.daxie.daxie_api.model.http.Categoryhttp;
import com.daxie.daxie_api.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;


/**
* Created by 代码生成器 on 2019/09/03.
*/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    //查找全部的
    @PostMapping("/selectall")
    public Result<List<Category>> list(@RequestBody Category category){
        String  categorykind =category.getCategorykind();
        Condition condition = new Condition(Category.class);
        condition.createCriteria().orCondition("categorykind =" + "'" + categorykind + "'" );
        List<Category> categoryList=categoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(categoryList);
    }
    //查找
    @PostMapping("/SelectById")
    public Result detail(@RequestBody Category category) {
        int  categoryid=category.getCategoryid();
        Category serviceById = categoryService.findById(categoryid);
        return ResultGenerator.genSuccessResult(serviceById);
    }
      //搜索页面是显示热门搜索categoryhot
    @PostMapping("/dim")
    public Result categoryhot(@RequestBody Category category) {
      Integer      categoryhot =  category.getCategoryhot();
      List<Category> categoryList=categoryService.hotcategory(categoryhot);
     return ResultGenerator.genSuccessResult(categoryList);
    }

     //模糊查询
     @PostMapping("/vague")
     public Result  vagueLilke(@RequestBody Category category){
       String  categoryname=category.getCategoryname();
       String categorykind =category.getCategorykind();
       if(categoryname==null &&categorykind!=null){
         return  ResultGenerator.genFailResult("请输入品牌名称！");
       }else {
           List<Category>   likelist=categoryService.vaguelike(categoryname,categorykind);
         return ResultGenerator.genSuccessResult(likelist);
        }
        }

        //正式提交
        @PostMapping("submitadd")
        public Result submit(@RequestBody Category category){
         int categoryCategoryid= category.getCategoryid();
        Category categoryByid  =categoryService.findById(categoryCategoryid);
        categoryByid.setCategorysatus(1);
          return ResultGenerator.genSuccessResult();
        }
        //种类
       @PostMapping("kind")
        public Result  kind(@RequestBody Category category){
        String   kind=category.getCategorykind();
        List<Category> categoryList=categoryService.findByIds(kind);
        return  ResultGenerator.genSuccessResult(categoryList);
       }

    @PostMapping("/select")
    public  Result   select(@RequestBody Categoryhttp category) {
        List<Requetvo> categorylist = category.getCategoryList();
        Cate cate = new Cate();
        String one =  categorylist.get(0).getFuhao();
        String two=  categorylist.get(1).getFuhao();
        String three =   categorylist.get(2).getFuhao();
        cate.setCategorysale(one);
        cate.setCategoryprice(two);
        cate.setCategorylirun(three);

       List<Category>  list=categoryService.select(cate);
        System.out.println(list);
    return ResultGenerator.genSuccessResult(list);
    }
//
//          return null;
//
//        }


        ////        int profit = category.getCategoryProfit();
//        int  categorykind= category.getCategorykind();
//
//             if(sales==501 || price==49 && liren==29) {
//                 condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'" + " or categoryprice=>" + "'" + price + "'" + " or categoryliren=>" + "'" + liren + "'");
//                 list = categoryService.findByCondition(condition);
//                 return ResultGenerator.genSuccessResult(list);
//             }
//        List    list2=new ArrayList();
//        List    list3=new ArrayList();
//        if(sales==501) {
//                 condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'");
//                 list = categoryService.findByCondition(condition);
//                 return ResultGenerator.genSuccessResult(list);
//             }else if (sales==499){
//            condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=<" + "'" + sales + "'");
//            list = categoryService.findByCondition(condition);
//            return ResultGenerator.genSuccessResult(list);
//
//        }
//       else if (price==51){
//            condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'");
//            list2= categoryService.findByCondition(condition);
//            return ResultGenerator.genSuccessResult(list2);
//        }else if (price==49){
//            condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'");
//            list2 = categoryService.findByCondition(condition);
//            return ResultGenerator.genSuccessResult(list2);}
//             else if (liren==0.048){
//                condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'");
//                list3= categoryService.findByCondition(condition);
//                return ResultGenerator.genSuccessResult(list3);
//            }else if (liren==0.047){
//                condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'");
//                list3 = categoryService.findByCondition(condition);
//                return ResultGenerator.genSuccessResult(list3);
//        }else {
//
//            return null;
//        }

//              if(sales==499 || price==45|| liren==28) {
//                 condition.createCriteria().orCondition("categorykind =" + "'" + kind + "'" + " or categorysales=>" + "'" + sales + "'" + " or categoryprice=>" + "'" + price + "'" + " or categoryliren=>" + "'" + liren + "'");
//                 list = categoryService.findByCondition(condition);
//                 return ResultGenerator.genSuccessResult(list);
//             }


        @PostMapping("/delete") public Result delete (@RequestParam Integer id){
            categoryService.deleteById(id);
            return ResultGenerator.genSuccessResult();
        }

        @PostMapping("/update") public Result update (Category category){
            int categorysatus = category.getCategorysatus();
            Category category1 = new Category();
            categoryService.update(category);
            return ResultGenerator.genSuccessResult();
        }

        @PostMapping("/detail") public Result detail (@RequestParam Integer id){
            Category category = categoryService.findById(id);
            return ResultGenerator.genSuccessResult(category);
        }

        @PostMapping("/list") public Result list (@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size){
            PageHelper.startPage(page, size);
            List<Category> list = categoryService.findAll();
            PageInfo pageInfo = new PageInfo(list);
            return ResultGenerator.genSuccessResult(pageInfo);
        }
    }
