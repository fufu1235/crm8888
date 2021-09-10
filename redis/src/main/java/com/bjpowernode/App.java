package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class App 
{
    public static void main( String[] args )
    {

         Jedis jedis = new Jedis("192.168.67.128", 6379);
         jedis.flushAll();
         jedis.set("a", "1");
        String a = jedis.get("a");
        System.out.println(a);

    }
}
