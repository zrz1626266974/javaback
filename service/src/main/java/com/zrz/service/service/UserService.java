package com.zrz.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VUser;

import java.util.List;


public interface UserService extends IService<User> {
//    public List<User> findAllUser();
    public List<VUser> getUserList();
    public VUser getUserById(String id);
    public List<VUser> userRank();
}
