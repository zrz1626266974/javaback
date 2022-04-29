package com.zrz.service.config.redis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Publisher {
    private final JedisPool jedisPool;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void start() {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis = jedisPool.getResource();
//        while (true) {
//            String line = null;
//            try {
//                line = reader.readLine();
//                if (!"quit".equals(line
        jedis.publish("mychannel", "testpublisher");
//                } else {
//                    break;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}