package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = true)
@Data
public class Admin {
    @TableId("id")
    private String id;
    private String psw;

}
