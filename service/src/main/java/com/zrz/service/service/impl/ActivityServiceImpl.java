package com.zrz.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.common.R;
import com.zrz.service.entity.Activity;
import com.zrz.service.entity.Admin;
import com.zrz.service.entity.view.VActivity;
import com.zrz.service.mapper.ActivityMapper;
import com.zrz.service.service.ActivityService;
import com.zrz.service.service.view.VActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private VActivityService vActivityService;

    public List<VActivity> getActivityList(){
        List<VActivity> activityList = vActivityService.list();
        return activityList;
    }

    //  分页获取活动
    @Override
    public Page<VActivity> getAcByPage(long cur, long limit, String keyword) {
        Page<VActivity> page = new Page<>(cur, limit);
        QueryWrapper<VActivity> wrapper = new QueryWrapper<>();
        wrapper.like("activity_name", keyword);
        vActivityService.page(page, wrapper);
        return page;
    }

    public VActivity getActivityById(int acid){
        QueryWrapper<VActivity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("acid", acid);
        VActivity one = vActivityService.getOne(queryWrapper);
        return one;
    }

    @Override
    public Page<VActivity> getAdminAcByPage(long cur,
                                            long limit,
                                            String keyword,
                                            Admin one) {
        Page<VActivity> page = new Page<>(cur, limit);
        QueryWrapper<VActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",one.getId());
        wrapper.like("activity_name", keyword);
        vActivityService.page(page, wrapper);
        return page;
    }

    @Override
    public List<VActivity> getActivityByAdmin(Admin one) {
        QueryWrapper<VActivity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",one.getId());
        List<VActivity> list = vActivityService.list(wrapper);
        return list;
    }


    public boolean updateActivity(Activity one){
        return activityMapper.updateActivity(one);
    }
}
