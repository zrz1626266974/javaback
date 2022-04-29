package com.zrz.service.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Type {
    @TableId("type_id")
    private Integer typeId;
    private String typeName;

}
