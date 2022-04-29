package com.zrz.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zrz.service.entity.Activity;
import com.zrz.service.entity.Admin;
import com.zrz.service.entity.view.VActivity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ActivityService extends IService<Activity> {
//    public List<Activity> getActivityList();

    public VActivity getActivityById(int acid);
    // -------- 分页获取管理员的活动 -------------
    public Page<VActivity> getAdminAcByPage(long cur, long limit, String keyword, Admin one);

    public List<VActivity> getActivityByAdmin(Admin one);

    public List<VActivity> getActivityList();

    // 分页获取活动列表
    public Page<VActivity> getAcByPage(long cur, long limit, String keyword);

    public boolean updateActivity(Activity one);
}
