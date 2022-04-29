package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Activity {
    @TableId(value = "acid",type = IdType.AUTO)
    private int acid;
    private String id;
    private int typeId;
    private String activityName;
    private String activityPlace;
    private Date stime;
    private Date etime;
    private String activityDetail;
    private int activityCount;
    private int activityPoint;
    private String activityLeader;
    private String activityTel;
    private Date activityTime;

//    private Type type;

}
