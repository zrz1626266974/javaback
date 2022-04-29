package com.zrz.service.controller;

import com.zrz.common.R;
import com.zrz.service.entity.vo.AmapInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/map")
public class MapController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/amap/{id}")
    public R getMapById(@PathVariable String id){

        String url = "https://restapi.amap.com/v3/place/detail?output=json";
        url += "&id=" + id;
        String key = "4941091cfb0ad8fe50255e410cff4929";
        url += "&key=" + key;

        AmapInfo one = restTemplate.getForObject(url, AmapInfo.class);
        return R.ok().data("one",one);
    }
}
