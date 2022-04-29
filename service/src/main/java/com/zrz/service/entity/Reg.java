package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Reg {

//    @TableId(value = "rid",type = IdType.AUTO)
//    private Integer rid;
    private String userId;
    private Integer acid;
    private Integer sid;
//    private String name;
//    private String identity;
    private String userTel;
    private Date regTime;
    private String major;
    private String degree;
    private String introduction;

}
