package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrz.common.R;
import com.zrz.service.config.utils.TokenUtils;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VUser;
import com.zrz.service.entity.vo.LoginModel;
import com.zrz.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/login")
    public R login(@RequestBody LoginModel loginModel){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String,String> map = new HashMap<>();
        map.put("user_id",loginModel.getId());
        map.put("psw",loginModel.getPsw());
        System.out.println(loginModel.getId() + "-" + loginModel.getPsw());
        queryWrapper.allEq(map);
        User one = userService.getOne(queryWrapper);
        if(one != null){
            String token = TokenUtils.token(one.getUserId(), one.getUserPsw());
            return R.ok().data("one",one).data("token",token);
        }
        else{
            return R.error().message("登录失败");
        }

    }

    //获取用户排名
    @GetMapping("/userRank")
    public R userRank(){
        List<VUser> list = userService.userRank();
        return R.ok().data("list",list);
    }

    @GetMapping("/getUserList")
    public R getUserList(){
//        List<User> list = userService.list();
        List<VUser> list = userService.getUserList();
        return R.ok().data("list",list);
    }

    @GetMapping("/getUserById/{id}")
    public R getUserById(@PathVariable String id){

        VUser one = userService.getUserById(id);
        return R.ok().data("one",one);
    }

    @PostMapping("/addUser")
    public R addUser(@RequestBody User user){
        boolean flag = userService.save(user);
        if(flag){
            return R.ok().message("用户添加成功");
        }
        else {
            return R.error().message("用户添加失败");
        }
    }

    @PostMapping("/delUser")
    public R delUser(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        boolean flag = userService.remove(queryWrapper);
        if(flag){
            return R.ok().message("用户删除成功");
        }
        else {
            return R.error().message("用户删除失败");
        }
    }

    @PostMapping("/updateUser")
    public R updateUser(@RequestBody User user){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",user.getUserId());
        boolean flag = userService.update(updateWrapper);
        if(flag){
            return R.ok().message("用户更新成功");
        }
        else {
            return R.error().message("用户更新失败");
        }
    }



}
