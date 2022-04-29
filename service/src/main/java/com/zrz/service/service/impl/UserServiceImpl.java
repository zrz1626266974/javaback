package com.zrz.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VUser;
import com.zrz.service.mapper.UserMapper;
import com.zrz.service.service.UserService;
import com.zrz.service.service.view.VUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private VUserService vUserService;

    // ------ 获取所有用户 ----------------
    @Override
    public List<VUser> getUserList() {
        List<VUser> list = vUserService.list();
        return list;
    }

    // -------- 根据用户userId 获取用户信息 ----------
    @Override
    public VUser getUserById(String userId) {
        QueryWrapper<VUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        VUser one = vUserService.getOne(wrapper);
        return one;
    }

    // 获取用户排名信息
    @Override
    public List<VUser> userRank() {
        QueryWrapper<VUser> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("user_point");
        wrapper.last("limit 100");
        List<VUser> list = vUserService.list(wrapper);
        return list;
    }
}
