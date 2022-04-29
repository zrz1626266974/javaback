package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Reply {
//    @TableId("id")
    @TableId(value = "reply_id",type = IdType.AUTO)
    private Integer replyId;
    private String userId;
//    @TableId("cid")
    private Integer cid;
    private String replyContent;
    private Date replyTime;

}
