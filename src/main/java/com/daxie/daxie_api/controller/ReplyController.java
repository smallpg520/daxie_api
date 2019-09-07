package com.daxie.daxie_api.controller;
import com.daxie.daxie_api.core.Result;
import com.daxie.daxie_api.core.ResultGenerator;
import com.daxie.daxie_api.core.UUIDS;
import com.daxie.daxie_api.model.Comments;
import com.daxie.daxie_api.model.Reply;
import com.daxie.daxie_api.service.ReplyService;
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
 * Created by 代码生成器 on 2019/01/22.
 */
@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @PostMapping("/add")
    public Result add(Reply reply) {
        reply.setReplyid("r"+ UUIDS.getDateUUID());
        reply.setCreatetime(UUIDS.getDateTime());
        System.out.println(UUIDS.getDateTime());
        replyService.save(reply);
        return ResultGenerator.genSuccessResult();
    }
    @PostMapping("/getReply")
    public Result getReply(@RequestParam String  problemid) {
        Condition condition = new Condition(Reply.class);
        condition.createCriteria().andCondition("problemid ="+"'"+problemid+"'");
        condition.setOrderByClause("createtime desc");
        List<Reply> list=replyService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        replyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Reply reply) {
        replyService.update(reply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Reply reply = replyService.findById(id);
        return ResultGenerator.genSuccessResult(reply);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Reply> list = replyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
