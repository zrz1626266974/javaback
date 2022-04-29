package com.zrz.service.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class CrossOriginConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")

            .allowCredentials(true)

            .allowedOriginPatterns("*")
            //放行哪些请求方式
            .allowedMethods("GET", "POST", "PUT", "DELETE")

            .allowedHeaders("*")

            .exposedHeaders("*");
    }
}