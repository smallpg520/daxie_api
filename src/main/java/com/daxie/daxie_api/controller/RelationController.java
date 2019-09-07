package com.daxie.daxie_api.controller;
import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.model.Comments;
import com.daxie.daxie_api.model.Relation;
import com.daxie.daxie_api.service.RelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 代码生成器 on 2019/01/23.
*/
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Resource
    private RelationService relationService;

    @PostMapping("/add")
    public Result add(Relation relation) {
        relationService.save(relation);
        return ResultGenerator.genSuccessResult();
    }
    //查看是否关注此用户
    @PostMapping("/getFollew")
    public Result getFollew(@RequestParam String userid,String foruserid) {
        Condition condition = new Condition(Relation.class);
        condition.createCriteria().andCondition("userid ="+"'"+userid+"'"+" and foruserid="+"'"+foruserid+"'");
        List<Relation> list=relationService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Relation relation = relationService.findById(id);
        return ResultGenerator.genSuccessResult(relation);
    }
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        relationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Relation relation) {
        relationService.update(relation);
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Relation> list = relationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
