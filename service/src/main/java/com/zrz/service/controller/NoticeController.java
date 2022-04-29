package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Article;
import com.zrz.service.entity.Notice;
import com.zrz.service.entity.User;
import com.zrz.service.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/getNoticeList")
    public R getNoticeList(){
        List<Notice> list = noticeService.list();
        return R.ok().data("list",list);
    }

    // ---- 获取分页公告 (同时匹配关键词搜索）----
    @GetMapping("/getNoticeByPage/{cur}/{limit}")
    public R getNoticeByPage(@PathVariable long cur,
                             @PathVariable long limit,
                             @RequestParam String keyword){
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.like("notice_title", keyword);
        Page<Notice> page = new Page<>(cur, limit);
        noticeService.page(page, wrapper);
        long total = page.getTotal();
        List<Notice> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

    @GetMapping("/getNoticeById/{id}")
    public R getNoticeById(@PathVariable int id){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nid",id);
        Notice one = noticeService.getOne(queryWrapper);
        return R.ok().data("one",one);
    }

    // 分页获取关键字搜索结果
//    @GetMapping("/searchNotice/{cur}/{limit}")
//    public R searchNotice(@RequestParam String keyword,
//                          @PathVariable long cur,
//                          @PathVariable long limit){
//        Page<Notice> page = new Page<>(cur, limit);
//        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
//        wrapper.like("title", keyword);
//        noticeService.page(page,wrapper);
//        long total = page.getTotal();
//        List<Notice> list = page.getRecords();
//        return R.ok().data("list", list).data("total", total);
//
//    }

    @PostMapping("/addNotice")
    public R addNotice(@RequestBody Notice notice){
        boolean flag = noticeService.save(notice);
        if(flag){
            return R.ok().message("公告添加成功");
        }
        else {
            return R.error().message("公告添加失败");
        }
    }

    @PostMapping("/delNotice")
    public R delNotice(@RequestBody Notice notice){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("nid",notice.getNid());
        boolean flag = noticeService.remove(queryWrapper);
        if(flag){
            return R.ok().message("公告删除成功");
        }
        else {
            return R.error().message("公告删除失败");
        }
    }

    @Transactional
    @PostMapping("/updateNotice")
    public R updateNotice(@RequestBody Notice notice){
        UpdateWrapper<Notice> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("nid",notice.getNid());
        boolean flag = noticeService.update(notice,updateWrapper);
        if(flag){
            return R.ok().message("公告更新成功");
        }
        else {
            return R.error().message("公告更新失败");
        }
    }
}
