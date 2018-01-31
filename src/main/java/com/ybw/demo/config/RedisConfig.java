package com.ybw.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by yao on 2018/1/22
 *redis配置
 */

@Configuration
public class RedisConfig{

    //读取yml配置
    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**建立jedis工厂*/
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        //实例化jedis工厂
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        //写入jedis工厂配置  ip 端口 密码
        jedisConnectionFactory.setHostName(env.getProperty("spring.redis.host"));
        jedisConnectionFactory.setPort(Integer.valueOf(env.getProperty("spring.redis.port")));
        jedisConnectionFactory.setPassword(env.getProperty("spring.redis.password"));
        //jedis类配置写入
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.valueOf(env.getProperty("spring.redis.pool.max-active")));
        jedisPoolConfig.setMaxIdle(Integer.valueOf(env.getProperty("spring.redis.pool.max-idle")));
        jedisPoolConfig.setMinIdle(Integer.valueOf(env.getProperty("spring.redis.pool.min-idle")));
        jedisPoolConfig.setMaxWaitMillis(Integer.valueOf(env.getProperty("spring.redis.pool.max-wait")));
        /*jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(env.getProperty("spring.redis.testOnBorrow")));
        jedisPoolConfig.setTestOnReturn(Boolean.valueOf(env.getProperty("spring.redis.testOnReturn")));
        jedisPoolConfig.setTestWhileIdle(Boolean.valueOf(env.getProperty("spring.redis.testWhileIdle")));*/
        //设置jedis工厂配置
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;

    }

    /**redis集群配置*/
    //@Bean
    public JedisConnectionFactory jedisConnectionFactory1(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        //redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        //redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        //redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        //redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        //redisClusterConfiguration.addClusterNode(new RedisNode(env.getProperty("spring.redis.host"),Integer.valueOf(env.getProperty("spring.redis.port"))));
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration);
        jedisConnectionFactory.setPassword(env.getProperty("spring.redis.password"));
        jedisConnectionFactory.setUsePool(true);

        //jedis类配置写入
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.valueOf(env.getProperty("spring.redis.pool.max-active")));
        jedisPoolConfig.setMaxIdle(Integer.valueOf(env.getProperty("spring.redis.pool.max-idle")));
        jedisPoolConfig.setMinIdle(Integer.valueOf(env.getProperty("spring.redis.pool.min-idle")));
        jedisPoolConfig.setMaxWaitMillis(Integer.valueOf(env.getProperty("spring.redis.pool.max-wait")));
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);

        return jedisConnectionFactory;
    }


    /**Redis模型管理*/
    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        final RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
        //配置模型
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }

}
