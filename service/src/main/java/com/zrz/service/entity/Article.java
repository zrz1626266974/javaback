package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Article {
    @TableId(value = "arid",type = IdType.AUTO)
    private Integer arid;
    private String userId;
    private String articleTitle;
    private String articleContent;
    private Date articleTime;

}
