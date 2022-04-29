package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrz.common.R;
import com.zrz.service.config.utils.TokenUtils;
import com.zrz.service.entity.Admin;
import com.zrz.service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAdminList")
    public R getAdminList(){
        List<Admin> list = adminService.list();
        return R.ok().data("list",list);
    }

    @GetMapping("/getAdminById/{id}")
    public R getAdminById(@PathVariable String id){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Admin one = adminService.getOne(queryWrapper);
        return R.ok().data("one",one);
    }

    //admin登录
    @PostMapping("/login")
    public R login(@RequestBody Admin account){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        Map<String,String> map = new HashMap<>();
        map.put("id",account.getId());
        map.put("psw",account.getPsw());
        System.out.println(account.getId() + "-" + account.getPsw());
        queryWrapper.allEq(map);
        Admin one = adminService.getOne(queryWrapper);
        if(one != null){
            String token = TokenUtils.token(one.getId(), one.getPsw());
            return R.ok().data("one",one).data("token",token);
        }
        else{
            return R.error().message("登录失败");
        }
    }
}
