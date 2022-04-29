package com.zrz.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrz.service.entity.Status;
import com.zrz.service.mapper.StatusMapper;
import com.zrz.service.service.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends ServiceImpl<StatusMapper, Status> implements StatusService {

}
