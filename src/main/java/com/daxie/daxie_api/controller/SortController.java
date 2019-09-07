package com.daxie.daxie_api.controller;
import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.model.Sort;
import com.daxie.daxie_api.redis.RedisUtil;
import com.daxie.daxie_api.service.SortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* Created by 代码生成器 on 2019/01/21.
*/
@RestController
@RequestMapping("/sort")
public class SortController {
    Logger log = LoggerFactory.getLogger(SortController.class);
    @Resource
    private SortService sortService;
    @Autowired
    private RedisUtil redisUtil;
    @PostMapping("/add")
    public Result add(Sort sort) {
        sortService.save(sort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sortService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Sort sort) {
        sortService.update(sort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Sort sort = sortService.findById(id);
        return ResultGenerator.genSuccessResult(sort);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        List<Sort> list=new ArrayList<>();

        //有缓存则读取
        try {
            String json= (String) redisUtil.get("sort");
            if (json!=null){
                list= new Gson().fromJson(json, new TypeToken<List<Sort>>(){}.getType());
                log.info(SortController.class.getSimpleName() + "获取了redis缓存");
                PageInfo pageInfo = new PageInfo(list);
                return ResultGenerator.genSuccessResult(pageInfo);
            }
        }catch (Exception e){
            log.error("获取缓存错误",e);
        }
        //没有缓存
        PageHelper.startPage(page, size);
        list = sortService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        //添加redies缓存
        try{
            redisUtil.set("sort", new Gson().toJson(list));
            log.info(SortController.class.getSimpleName() + "导航栏已缓存");
        }catch (Exception e){
            log.error("缓存错误",e);
        }
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
