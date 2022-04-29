package com.zrz.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrz.common.R;
import com.zrz.service.entity.Reg;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VReg;
import com.zrz.service.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reg")
public class RegController {

    @Autowired
    private RegService regService;

//    @GetMapping("/getRegList")
//    public R getRegList() {
////        List<Reg> list = regService.list();
//        List<VReg> list = regService.getRegList();
//        return R.ok().data("list", list);
//    }

    // 通过id获取报名表Registration
//    @GetMapping("/getRegById/{id}")
//    public R getRegById(@PathVariable int id) {
//        VReg one;
//        one = regService.getRegById(id);
//        if (one != null) {
//            return R.ok().data("one", one);
//        } else {
//            return R.error().message("报名表不存在");
//        }
//    }

    // =====  获取某一具体报名表 --------------
    @GetMapping("/getRegById")
    public R getRegById(@RequestParam String id,
                        @RequestParam int acid)
    {
        VReg one = regService.getRegById(id, acid);
        return R.ok().data("one", one);
    }

    // --------分页获取用户报名表 (同时关键词搜索)---------
    @PostMapping("/getUserRegByPage/{cur}/{limit}")
    public R getUserRegByPage(@PathVariable long cur,
                              @PathVariable long limit,
                              @RequestParam String keyword,
                              @RequestBody User one) {
        Page<VReg> page = regService.getUserRegByPage(cur, limit, keyword, one);
        long total = page.getTotal();
        List<VReg> list = page.getRecords();
        return R.ok().data("list", list).data("total", total);

    }

    // ---------- 分页获取活动相应的报名表 ---------------
    @GetMapping("/getRegByAcPage/{cur}/{limit}")
    public R getRegByAcPage(@PathVariable long cur,
                            @PathVariable long limit,
                            @RequestParam String keyword,
                            @RequestParam int acid)
    {
        Page<VReg> page = regService.getRegByAcPage(cur, limit, keyword, acid);
        long total = page.getTotal();
        List<VReg> list = page.getRecords();
        return R.ok().data("list", list).data("total", total);
    }

    // 通过活动acid和用户id获取报名表registration
    @PostMapping("/getRegByUserAndActivity")
    public R getRegByUserAndActivity(String id, int acid){
        QueryWrapper<Reg> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("acid",acid);
        Map<String,Object> map = new HashMap<>();
        map.put("acid",acid);
        map.put("user_id",id);
        queryWrapper.allEq(map);
        Reg one = regService.getOne(queryWrapper);
        if(one != null){
            return R.ok().data("one",one);
        }
        else{
            return R.error().message("用户无报名表");
        }
    }

    // 更改报名表状态
    @PostMapping("/updateReg")
    public R updateReg(@RequestBody Reg one){
        UpdateWrapper<Reg> wrapper = new UpdateWrapper<>();
//        wrapper.eq("rid",one.getRid());
        wrapper.eq("user_id", one.getUserId());
        wrapper.eq("acid", one.getAcid());
        System.out.println(one);
        boolean flag = regService.update(one,wrapper);
        if(flag){
            return R.ok().message("Reg更改成功");
        }
        else{
            return R.error().message("Reg更改失败");
        }
    }

    // 新增报名表
    @PostMapping("/addReg")
    public R addReg(@RequestBody Reg one){
        boolean flag = regService.save(one);
        if (flag) {
           return R.ok().message("添加报名表成功");
        }
        else {
            return R.error().message("添加报名表失败");
        }
    }

    // 删除报名表
    @PostMapping("/delReg")
    public R delReg(@RequestBody Reg one){
        UpdateWrapper<Reg> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("rid",one.getRid());
        updateWrapper.eq("user_id", one.getUserId());
        updateWrapper.eq("acid", one.getAcid());
        boolean flag = false;
        flag = regService.remove(updateWrapper);
        if(flag) {
            return R.ok().message("报名表删除成功");
        }
        else {
            return R.ok().message("报名表删除失败");
        }
    }


}

