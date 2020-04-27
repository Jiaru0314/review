package com.xzq.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @ClassName: TestTX
 * @description:
 * @author: XZQ
 * @create: 2020/4/7 7:56
 **/
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "xiaohong");
        jsonObject.put("age", 101);
        String result = jsonObject.toJSONString();

        //开启事务
        Transaction multi = jedis.multi();

        try {
            multi.set("user1", result);
            multi.set("user2", result);
            int i = 1 / 0;
            multi.exec();//执行事务
        } catch (Exception e) {
            multi.discard();//放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user1"));
            jedis.close();//关闭连接
        }
    }
}
