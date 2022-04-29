package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrz.common.R;
import com.zrz.service.entity.Status;
import com.zrz.service.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/getStatusList")
    public R getStatusList(){
        List<Status> list = statusService.list();
        return R.ok().data("list",list);
    }

    @GetMapping("/getStatusById/{id}")
    public R getStatusById(@PathVariable int id){
        QueryWrapper<Status> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid",id);
        Status one = statusService.getOne(queryWrapper);
        return R.ok().data("one",one);
    }


}
