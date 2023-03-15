package com.example.template.service.impl;

import com.example.template.service.RedisService;
import com.example.template.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String testRedis() {
        redisUtil.set("test", "123");
        return redisUtil.get("test");
    }
}
