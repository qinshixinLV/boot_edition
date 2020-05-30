package com.example.boot_edition.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisTemplateConfig {


    @Value("${spring.redis.host1}")
    private String redisHost1;

    @Value("${spring.redis.port1}")
    private int redisPort1;

    @Value("${spring.redis.database1}")
    private int redis1Database1;

    @Value("${spring.redis.password1}")
    private String redis1Password1;

    @Value("${spring.redis.host2}")
    private String redisHost2;

    @Value("${spring.redis.port2}")
    private int redisPort2;

    @Value("${spring.redis.database2}")
    private int redis1Database2;

    @Value("${spring.redis.password2}")
    private String redis1Password2;


    private static final int MAX_IDLE = 200; //最大空闲连接数
    private static final int MAX_TOTAL = 2048; //最大连接数
    private static final long MAX_WAIT_MILLIS = 10000; //建立连接最长等待时间

    //连接池
    public JedisPoolConfig poolConfig(int maxIdle, int maxTotal, long maxWaitMillis, boolean testOnBorrow) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setTestOnBorrow(testOnBorrow);
        return poolConfig;
    }


    //工厂
    public RedisConnectionFactory connectionFactory(String host, int port, String password, int maxIdle,
                                                    int maxTotal, long maxWaitMillis, int index) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);

        if (!StringUtils.isEmpty(password)) {
            jedisConnectionFactory.setPassword(password);
        }

        if (index != 0) {
            jedisConnectionFactory.setDatabase(index);
        }

        jedisConnectionFactory.setPoolConfig(poolConfig(maxIdle, maxTotal, maxWaitMillis, true));
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }


    @Bean(name = "redisTemplate1")
    public StringRedisTemplate redisTemplate1() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(
                connectionFactory(redisHost1, redisPort1, redis1Password1, MAX_IDLE, MAX_TOTAL, MAX_WAIT_MILLIS, redis1Database1));
        //template.setEnableTransactionSupport(false);
        return template;
    }

    @Bean(name = "redisTemplate2")
    public StringRedisTemplate userTemplate2() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(
                connectionFactory(redisHost2, redisPort2, redis1Password2, MAX_IDLE, MAX_TOTAL, MAX_WAIT_MILLIS, redis1Database2));
//        template.setEnableTransactionSupport(false);
        return template;
    }

}