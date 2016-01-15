package com.yizhilu.os.core.service.cache;

import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by liuqinggang on 15/12/21.
 */
public interface RedisService {


    /**
     * 获取
     *
     * @param key
     * @return Object
     */
    public  Object get(String key) ;

    /**
     * 设置对象默认时间是1天
     *
     * @param key
     * @param value
     * @return
     */
    public  void set(String key, Object value);

    /**
     * 设置超时时间
     *
     * @param key     键
     * @param value   值
     * @param seconds 时间（秒） 60*60为一小时
     * @return
     */
    public  void set(String key, Object value, int seconds);
    /**
     * 设置超时时间
     *
     * @param key     键
     * @param seconds 时间（秒） 60*60为一小时
     * @param value   值
     * @return
     */
    public  void setObject(String key, int seconds, Object value);

    /**
     * 根据key删除
     *
     * @param key
     * @return
     */
    public  void remove(String key);

    /**
     * 更新过期时间
     *
     * @param key
     * @param seconds
     * @return
     */
    public  Object exprie(String key, int seconds);
    /**
     * 获取缓存原生客户端
     *
     * @return
     */
    public RedisTemplate getCache();

}
