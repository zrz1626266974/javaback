package com.zrz.service.entity.view;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("v_user")
public class VUser {
    private String userId;
//    private String userPsw;
    private boolean sex;
    private String mail;
    private Date birthday;
    private Integer userPoint;
    private String identity;
    private String userName;
    private Integer countArid;
    private Integer age;
    private Integer countSid1;
    private Integer countSid2;
    private Integer countSid3;
    private Integer countSid4;
}
