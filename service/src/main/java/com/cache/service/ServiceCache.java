package com.cache.service;

import Model.User;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


public class ServiceCache {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory; //it provide to configure the hostname and port number
    }

    @Bean
    RedisTemplate<String, User> redisTemplate(){
        RedisTemplate<String,User> redisTemplate = new RedisTemplate<String, User>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return  redisTemplate;
    }
}
