package com.zrz.service.entity.view;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("v_activity")
public class VActivity {
    private int typeId;
    private String id;
    private int acid;
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
    private String typeName;
}
