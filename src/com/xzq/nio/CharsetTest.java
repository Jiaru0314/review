package com.xzq.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @ClassName: TestCharset
 * @description:
 * @author: XZQ
 * @create: 2020/4/15 11:07
 **/
public class CharsetTest {
    public static void main(String[] args) {
        getAvailableCharsets();
    }

    public static void getAvailableCharsets() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
