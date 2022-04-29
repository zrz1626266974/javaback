package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Article;
import com.zrz.service.entity.Comment;
import com.zrz.service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getCommentList")
    public R getCommentList() {
        List<Comment> list;
        list = commentService.list();
        return R.ok().data("list",list);
    }

    @GetMapping("/getCommentByPage/{arid}/{cur}/{limit}")
    public R getCommentByPage(@PathVariable int arid,
                              @PathVariable long cur,
                              @PathVariable long limit){
        Page<Comment> page = new Page<>(cur, limit);
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("arid",arid);
        commentService.page(page, wrapper);
        long total = page.getTotal();
        List<Comment> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

    @GetMapping("/getCommentById/{cid}")
    public R getCommentById(@PathVariable int cid){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("cid",cid);
        Comment one;
        one = commentService.getOne(wrapper);
        if(one != null){
            return R.ok().data("one",one);
        }
        else {
            return R.error().message("评论不存在");
        }
    }

    @GetMapping("/getCommentByArticle/{arid}")
    public R getCommentByArticle(@PathVariable int arid) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("arid",arid);
        List<Comment> list;
        list = commentService.list(wrapper);
        return R.ok().data("list",list);
    }


    @PostMapping("/addComment")
    public R addComment(@RequestBody Comment one) {
        boolean flag = false;
        flag = commentService.save(one);
        if(flag){
            return R.ok().message("评论增加成功");
        }
        else {
            return R.error().message("评论增加失败");
        }
    }

    @PostMapping("/delComment")
    public R delComment(@RequestBody Comment one){
        boolean flag = false;
        UpdateWrapper<Comment> wrapper = new UpdateWrapper<>();
        wrapper.eq("cid" ,one.getCid());
        flag = commentService.remove(wrapper);
        if(flag){
            return R.ok().message("评论删除成功");
        }
        else {
            return R.error().message("评论删除失败");
        }
    }

}
