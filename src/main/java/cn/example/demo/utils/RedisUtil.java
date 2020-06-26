package cn.example.demo.utils;

import cn.example.demo.config.RedisBasicMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yj
 * 2020/6/22
 * @description redis 设置缓存工具类
 **/
@Service
public class RedisUtil implements RedisBasicMethod {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置缓存
     *
     * @param key   键名
     * @param value 值
     * @return boolean
     */
    @Override
    public boolean setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return false;
    }

    /**
     * 设置缓存过期时间
     *
     * @param key    键名
     * @param value  值
     * @param expire 过期时间 单位分钟
     * @return boolean
     */
    @Override
    public boolean setValue(String key, String value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MINUTES);
        return false;
    }

    /**
     * 移除指定的缓存
     *
     * @param key 键名
     * @return boolean
     */
    @Override
    public boolean remove(String key) {
        return false;
    }

    /**
     * 获取指定的缓存
     *
     * @param key 键名
     * @return map
     */
    @Override
    public Map<String, Object> getValues(String key) {
        Map<String, Object> map = new HashMap<>(16);
        map.put(key, redisTemplate.opsForValue().get(key));
        return map;
    }

    /**
     * 获取所有的缓存
     *
     * @return map
     */
    @Override
    public Map<String, Object> getValues() {
        return null;
    }
}
