package com.zrz.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zrz.service.entity.Reg;
import com.zrz.service.entity.User;
import com.zrz.service.entity.view.VReg;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RegService extends IService<Reg> {
//    public List<VReg> getRegList();
//    public VReg getRegById(int rid);
//    public List<VReg> getRegByActivity(int acid);
//    public List<VReg> getRegByActivity(Reg one);
//    public List<VReg> getRegByUser(User one);

    // -------- 获取具体报名表 ------------
    public VReg getRegById( String id,int acid);
    // ----- 分页获取用户的报名表 --------
    public Page<VReg> getUserRegByPage(long cur, long limit, String keyword, User one);
    // -------- 分页获取活动相应的报名表 -----------
    public Page<VReg> getRegByAcPage(long cur, long limit, String keyword, int acid);
}
