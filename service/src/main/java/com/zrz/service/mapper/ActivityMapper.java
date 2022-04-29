package com.zrz.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrz.service.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    // 获取所有活动含类型名称
    public List<Activity> getActivityList();

    // 根据id获取活动
    public Activity getActivityById(int acid);

    // 更新活动表
    public boolean updateActivity(Activity one);
}
