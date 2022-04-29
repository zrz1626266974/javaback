package com.zrz.service;

import com.zrz.common.R;
import com.zrz.service.config.redis.Publisher;
import com.zrz.service.config.redis.SubThread;
import com.zrz.service.config.utils.EmailUtils;
import com.zrz.service.controller.ActivityController;
import com.zrz.service.entity.view.VUser;
import com.zrz.service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ServiceApplicationTests {

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

//    @Autowired
//    private ChannelTopic topic;


    @Test
    void contextLoads() {
//        Jedis jedis = new Jedis();
//        jedis.set("key1","value1");
//        String s = jedis.get("key1");
//        System.out.println(s);
//        jedis.flushDB();
//        jedis.close();
        String redisIp = "127.0.0.1";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

        SubThread subThread = new SubThread(jedisPool);
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
    @Autowired
    private UserService userService;
    @Test
    void tes01() {
        List<VUser> list = userService.userRank();
        System.out.println(list);
    }

    @Autowired
    private EmailUtils emailUtils;
    @Test
    void testEmail() {
//        EmailUtils emailUtils
        emailUtils.test();
    }
}
