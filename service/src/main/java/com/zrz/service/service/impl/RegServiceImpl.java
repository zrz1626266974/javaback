package com.zrz.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.common.R;
import com.zrz.service.entity.Reg;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VReg;
import com.zrz.service.mapper.RegMapper;
import com.zrz.service.service.RegService;
import com.zrz.service.service.view.VRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegServiceImpl extends ServiceImpl<RegMapper, Reg> implements RegService {

    @Autowired
    private VRegService vRegService;


    // ---------- 获取具体用户某一报名表 -------------
    @Override
    public VReg getRegById(String userId, int acid) {
        QueryWrapper<VReg> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.like("acid", acid);
        VReg one = vRegService.getOne(wrapper);
        return one;
    }

    // ------- 分页获取用户报名表 -------------
    @Override
    public Page<VReg> getUserRegByPage(long cur,
                                       long limit,
                                       String keyword,
                                       User one) {
        Page<VReg> page = new Page<>(cur, limit);
        QueryWrapper<VReg> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", one.getUserId());
        wrapper.like("activity_name", keyword);

        vRegService.page(page,wrapper);
        return page;
    }

    @Override
    public Page<VReg> getRegByAcPage(long cur, long limit, String keyword, int acid) {
        Page<VReg> page = new Page<>(cur, limit);
        QueryWrapper<VReg> wrapper = new QueryWrapper<>();
        wrapper.eq("acid", acid);
        wrapper.like("activity_name", keyword);
        vRegService.page(page, wrapper);

        return page;
        
    }
}
