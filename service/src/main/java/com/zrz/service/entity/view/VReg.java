package com.zrz.service.entity.view;

import lombok.Data;

import java.util.Date;

@Data
public class VReg {
//    private Integer rid;
    private String userId;
    private Integer acid;
    private Integer sid;
    private String userName;
    private String identity;
    private String userTel;
    private Date regTime;
    private String description;
    private String activityName;
//    private Integer activityCount;
//    private Integer activityPoint;
    private Integer userPoint;
    private Boolean sex;
    private String major;
    private String degree;
    private String introduction;

}
