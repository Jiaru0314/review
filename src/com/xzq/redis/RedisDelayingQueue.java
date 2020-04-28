package com.xzq.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName: RedisDelayingQueue
 * @description: Redis延时队列的实现
 * @author: XZQ
 * @create: 2020/4/28 8:58
 * 参考《Redis深度历险》
 **/
public class RedisDelayingQueue<T> {

    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private Jedis jedis;
    private String queueKey;
    //fastjson 序列化对象中存在generic类型时需要使用TypeReference
    private final Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<>();
        //分配唯一的id
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        //序列化
        String s = JSON.toJSONString(task);
        //塞入延时队列
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }


    public void loop() {
        while (!Thread.interrupted()) {
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            if (jedis.zrem(queueKey, s) > 0) {//抢到了
                //反序列化
                TaskItem<T> task = JSON.parseObject(s, TaskType);
                this.handleMsg(task.msg);
            }
        }
    }

    //消息处理
    public void handleMsg(T msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        RedisDelayingQueue<String> queue = new RedisDelayingQueue<>(jedis, "q-demo");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("jiaru" + i);
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            queue.loop();
        }, "consumer");

        producer.start();
        consumer.start();

        try {
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {

        }
    }


}
