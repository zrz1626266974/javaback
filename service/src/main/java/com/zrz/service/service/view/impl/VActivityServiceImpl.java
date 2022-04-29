package com.zrz.service.service.view.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.service.entity.view.VActivity;
import com.zrz.service.mapper.view.VActivityMapper;
import com.zrz.service.service.view.VActivityService;
import org.springframework.stereotype.Service;

@Service
public class VActivityServiceImpl extends ServiceImpl<VActivityMapper, VActivity> implements VActivityService {
}
