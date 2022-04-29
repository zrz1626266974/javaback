package com.zrz.service.service.view.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.service.entity.view.VReg;
import com.zrz.service.mapper.view.VRegMapper;
import com.zrz.service.service.view.VRegService;
import org.springframework.stereotype.Service;

@Service
public class VRegServiceImpl extends ServiceImpl<VRegMapper, VReg> implements VRegService {
}
