package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Notice {
    @TableId(value = "nid",type = IdType.AUTO)
    private Integer nid;
    private String id;
    private String noticeTitle;
    private String noticeContent;
    private Date noticeTime;

}
