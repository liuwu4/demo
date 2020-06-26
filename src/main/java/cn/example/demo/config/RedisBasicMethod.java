package cn.example.demo.config;

import java.util.Map;

/**
 * @author yj
 * 2020/6/22
 * @description redis 基本操作
 **/
public interface RedisBasicMethod {
    /**
     * 设置缓存
     *
     * @param key   键名
     * @param value 值
     * @return boolean
     */
    boolean setValue(String key, String value);

    /**
     * 设置缓存过期时间
     *
     * @param key    键名
     * @param value  值
     * @param expire 过期时间
     * @return boolean
     */
    boolean setValue(String key, String value, long expire);

    /**
     * 移除指定的缓存
     *
     * @param key 键名
     * @return boolean
     */
    boolean remove(String key);

    /**
     * 获取指定的缓存
     *
     * @param key 键名
     * @return map
     */
    Map<String, Object> getValues(String key);

    /**
     * 获取所有的缓存
     *
     * @return map
     */
    Map<String, Object> getValues();
}
