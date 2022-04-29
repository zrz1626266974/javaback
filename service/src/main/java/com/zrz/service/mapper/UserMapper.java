package com.zrz.service.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrz.service.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    public List<User> findAllUser();
}
