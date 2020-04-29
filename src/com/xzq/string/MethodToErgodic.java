package com.xzq.string;

/**
 * @ClassName: MethodToErgodic
 * @description: 遍历String的方式
 * @author: XZQ
 * @create: 2020/4/29 11:03
 **/
public class MethodToErgodic {

    public void ergodic(String S) {
        for (char c : S.toCharArray()) {
        }


    }

    public void ergodic2(String S) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {

            }
        }
    }


    public void ergodic3(String S) {
        byte[] bytes = S.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 'a') {
            }
        }
    }
}