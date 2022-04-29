package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Activity;
import com.zrz.service.entity.Admin;
import com.zrz.service.entity.view.VActivity;
import com.zrz.service.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // -------- 分页获取管理员活动 -----------------
    @PostMapping("/getAdminAcByPage/{cur}/{limit}")
    public R getAdminAcByPage(@PathVariable long cur,
                              @PathVariable long limit,
                              @RequestParam String keyword,
                              @RequestBody Admin one)
    {
        Page<VActivity> page = activityService.getAdminAcByPage(cur, limit, keyword, one);
        long total = page.getTotal();
        List<VActivity> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

    @GetMapping("/getActivityById/{acid}")
    public R getActivityById(@PathVariable int acid){
        VActivity one = activityService.getActivityById(acid);
        return R.ok().data("one",one);
    }

    // --- 分页获取所有活动 ---
    @GetMapping("/getAcByPage/{cur}/{limit}")
    public R getAcByPage(@PathVariable long cur,
                         @PathVariable long limit,
                         @RequestParam String keyword){
        Page<VActivity> page = activityService.getAcByPage(cur,limit,keyword);
        long total = page.getTotal();
        List<VActivity> list = page.getRecords();
        return R.ok().data("total", total).data("list",list);
    }

    // ------------- 更新活动 -----------------
    @Transactional
    @PostMapping("/update")
    public R update(@RequestBody(required = false) VActivity one){
        boolean isSuccess = false;
        UpdateWrapper<Activity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("acid", one.getAcid());
        Activity a = new Activity();
        BeanUtils.copyProperties(one,a);
        isSuccess = activityService.update(a,updateWrapper);
        if(isSuccess){
            return R.ok().message("活动更新成功");
        }
        else{
            return R.error().message("活动更新失败");
        }
    }

    // ----------- 删除活动 ----------------------
    @PostMapping("/delActivity")
    public R delActivity(@RequestBody Activity one){
        UpdateWrapper<Activity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("acid", one.getAcid());
        boolean flag = activityService.remove(updateWrapper);
        if(flag){
            return R.ok().message("活动删除成功");
        }
        else {
            return R.error().message("活动删除失败");
        }
    }

    @PostMapping("/addActivity")
    public R addActivity(@RequestBody Activity one){
        boolean flag = activityService.save(one);
        if(flag){
            return R.ok().message("活动添加成功");
        }
        else {
            return R.error().message("活动添加失败");
        }
    }
}
