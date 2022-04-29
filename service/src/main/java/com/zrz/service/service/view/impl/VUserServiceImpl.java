package com.zrz.service.service.view.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.service.entity.view.VUser;
import com.zrz.service.mapper.view.VUserMapper;
import com.zrz.service.service.view.VUserService;
import org.springframework.stereotype.Service;

@Service
public class VUserServiceImpl extends ServiceImpl<VUserMapper, VUser>  implements VUserService {

}
