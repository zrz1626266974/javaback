package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Status {
    @TableId("sid")
    private Integer sid;
    private String description;


}
