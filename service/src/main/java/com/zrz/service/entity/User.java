package com.zrz.service.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    @TableId("id")
    private String userId;
    private String userPsw;
    private boolean sex;
    private Date birthday;
    private Integer userPoint;
    private String identity;
    private String userName;
    private String mail;
}
