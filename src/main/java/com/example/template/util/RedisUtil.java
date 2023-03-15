package com.example.template.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public List<String> mget(List<String> keyList) {
        return stringRedisTemplate.opsForValue().multiGet(keyList);
    }

    public String getAndSet(String key, String value) {
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    public long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    public long increment(String key, long delta, long timeout, TimeUnit timeUnit) {
        long i = increment(key, delta);
        expire(key, timeout, timeUnit);
        return i;
    }

    public void expire(String key, long timeout, TimeUnit timeUnit) {
        stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    public void hset(String key, String hashKey, String value) {
        stringRedisTemplate.opsForHash().put(key, hashKey, value);
    }

    public void hdel(String key, String hashKey) {
        stringRedisTemplate.opsForHash().delete(key, hashKey);
    }

    public String hget(String key, String hashKey) {
        Object cache = stringRedisTemplate.opsForHash().get(key, hashKey);
        return cache == null ? null : (String) cache;
    }

    public Long llen(String key) {
        return stringRedisTemplate.opsForList().size(key);
    }

    public Long lpush(String key, String value) {
        return stringRedisTemplate.opsForList().leftPush(key, value);
    }

    public String lindex(String key, long index) {
        return stringRedisTemplate.opsForList().index(key, index);
    }

    public List<String> lrange(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    public Long lrem(String key, long count, String value) {
        return stringRedisTemplate.opsForList().remove(key, count, value);
    }

    public Long rpush(String key, String value) {
        return stringRedisTemplate.opsForList().rightPush(key, value);
    }

    public String lpop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    public String rpop(String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    public long getExpire(String key, TimeUnit timeUnit) {
        return stringRedisTemplate.getExpire(key, timeUnit);
    }
}
