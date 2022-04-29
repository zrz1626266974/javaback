package com.zrz.service.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AmapInfo implements Serializable {
    private String status;
    private String info;
    private List<AmapPoi> pois;

}
