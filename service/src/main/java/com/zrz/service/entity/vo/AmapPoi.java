package com.zrz.service.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AmapPoi implements Serializable {
    private String id;
    private String adcode;
    private String pname;
    private String cityname;
    private String adname;
    private String address;
    private String name;
    private String location;
}
