package com.bjpowernode;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool pool = null;

    public static JedisPool open(String use, int i){
        JedisPoolConfig ser = new JedisPoolConfig();
        ser.setMaxTotal(10);
        ser.setMaxIdle(5);
        pool = new JedisPool(ser, use, i);
        return pool;
    }


    public static void clear(){
        pool.close();
    }

}
