package com.xzq.thread.interview_A1B2C3;

/**
 * @ClassName: CASDemo
 * @description: 两个线程交叉打印，一个打印数字，一个打印小写字母，结果为 1A2B3C4D5E6F
 * CAS实现
 * @author: XZQ
 * @create: 2020/3/15 15:56
 **/
public class CASDemo {
    enum ReadToRun {T1, T2}//枚举 规范参数的形式

    static volatile ReadToRun r = ReadToRun.T1;//保证可见性

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r != ReadToRun.T1) {
                }
                System.out.print(c);
                r = ReadToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (r != ReadToRun.T2) {
                }
                System.out.print(c);
                r = ReadToRun.T1;
            }
        }, "t2").start();
    }
}
