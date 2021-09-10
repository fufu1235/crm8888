package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

public class App1
{
    public static void main( String[] args )
    {
        try {
            JedisPool open = RedisUtils.open("192.168.67.128", 6379);
            Jedis resource = open.getResource();
            resource.set("b", "10");
            String b = resource.get("b");
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            RedisUtils.clear();
        }

    }
}
