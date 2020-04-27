package com.xzq.collection.map;

import com.xzq.pojo.User;

import java.util.*;

/**
 * @ClassName: HashMapDemo
 * @description: 实现对HashMap排序
 * @author: XZQ
 * @create: 2020/3/25 11:00
 **/
public class HashMapSortDemo {

    public static void main(String[] args) {
        HashMap<Integer, User> map = new HashMap<>(16);

        map.put(1, new User("xiaohong", 20));
        map.put(2, new User("xiaohei", 21));
        map.put(3, new User("wangwu", 22));
        map.put(4, new User("zhangsan", 23));

        HashMap<Integer, User> userHashMap = sortedHashMap(map);

        System.out.println(userHashMap);
    }

    private static HashMap<Integer, User> sortedHashMap(HashMap<Integer, User> hashMap) {

        Set<Map.Entry<Integer, User>> entrySet = hashMap.entrySet();
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);

        list.sort((o1, o2) -> o2.getValue().getAge() - o1.getValue().getAge());

        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();

        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        return linkedHashMap;
    }
}
