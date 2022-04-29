package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zrz.common.R;
import com.zrz.service.entity.Type;
import com.zrz.service.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/getTypeList")
    public R getTypeList(){
        List<Type> list = typeService.list();
        return R.ok().data("list",list);
    }

    @GetMapping("/getTypeById/{id}")
    public R getTypeById(@PathVariable int id){
        QueryWrapper<Type> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id", id);
        Type type = typeService.getOne(queryWrapper);
        return R.ok().data("one",type);
    }
}
