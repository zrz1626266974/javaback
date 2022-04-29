package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Comment {
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;
    private String userId;
    private Integer arid;
    private String commentContent;
    private Date commentTime;

}
