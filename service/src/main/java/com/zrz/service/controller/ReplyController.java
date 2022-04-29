package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Comment;
import com.zrz.service.entity.Reply;
import com.zrz.service.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    //  -------- 分页获取评论的回复列表 ------------------
    @PostMapping("/getReplyByComment/{cur}/{limit}")
    public R getReplyByComment(@PathVariable long cur,
                               @PathVariable long limit,
                               @RequestBody Comment one) {
        QueryWrapper<Reply> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",one.getCid());
        Page<Reply> page = new Page<>(cur, limit);
        replyService.page(page, wrapper);
        long total = page.getTotal();
        List<Reply> list = page.getRecords();
//        List<Reply> list = replyService.list(wrapper);
        return R.ok().data("list",list).data("total", total);
    }

    @PostMapping("/addReply")
    public R addReply(@RequestBody Reply one) {
        boolean flag = false;
        flag = replyService.save(one);
        if(flag){
            return R.ok().message("评论成功");
        }
        else {
            return R.error().message("评论失败");
        }
    }

    @PostMapping("/delReply")
    public R delReply(@RequestBody Reply one) {
        UpdateWrapper<Reply> wrapper = new UpdateWrapper<>();
        wrapper.eq("reply_id",one.getReplyId());
        boolean flag = false;
        flag = replyService.remove(wrapper);
        if(flag){
            return R.ok().message("评论删除成功");
        }
        else{
            return R.error().message("评论删除失败");
        }
    }
}
