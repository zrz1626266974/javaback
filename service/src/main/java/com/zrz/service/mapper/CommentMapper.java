package com.zrz.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrz.service.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
