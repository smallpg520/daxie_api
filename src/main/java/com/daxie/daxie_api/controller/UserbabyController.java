package com.daxie.daxie_api.controller;
import com.daxie.daxie_api.configurer.PassToken;
import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.core.UUIDS;
import com.daxie.daxie_api.model.Userbaby;
import com.daxie.daxie_api.service.UserbabyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* Created by 代码生成器 on 2019/08/30.
*/
@RestController
@RequestMapping("/userbaby")
public class UserbabyController {
    @Resource
    private UserbabyService userbabyService;

    //添加用户
    @PostMapping("/add")

    public Result add(@RequestBody Userbaby userbaby) {
        Userbaby  user=new Userbaby();
        //判断手机号是否为空
        Userbaby u =userbabyService.findBy("mobile",userbaby.getMobile());
        if(u==null || userbaby.getMobile()==null){
            //用户添加手机号，用户姓名，种类，判断的token，创建的时间
            user.setMobile(userbaby.getMobile());
            user.setUsername(userbaby.getUsername());
            user.setKind(userbaby.getKind());
            user.setToken(UUIDS.getDateUUID());
            user.setCreatetime(new Date());
        }else if (u!=null){
            return  ResultGenerator.genFailResult("手机号重复，无法添加，请核对过后添加！");
        }

        userbabyService.save(user);
        return ResultGenerator.genSuccessResult(user);
    }



//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        userbabyService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Userbaby userbaby) {
//        userbabyService.update(userbaby);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Userbaby userbaby = userbabyService.findById(id);
//        return ResultGenerator.genSuccessResult(userbaby);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Userbaby> list = userbabyService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
