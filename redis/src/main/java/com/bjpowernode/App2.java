package com.bjpowernode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sun.plugin2.message.GetAppletMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) {
        {
            try {
                JedisPool open = RedisUtils.open("192.168.67.128", 6379);
                Jedis resource = open.getResource();
                Map<String, String> map = new HashMap<>();
                map.put("baidu", "www.baidu.com");
                map.put("taobao", "www.taobao.com");
                resource.hmset("myweb", map);

                List<String> hmget = resource.hmget("myweb", "baidu", "taobao");
                System.out.println(hmget);


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                RedisUtils.clear();
            }
        }
    }
}
