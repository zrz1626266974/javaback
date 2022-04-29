package com.zrz.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zrz.service.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
