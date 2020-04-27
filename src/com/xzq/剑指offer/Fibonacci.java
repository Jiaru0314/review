package com.xzq.剑指offer;

/**
 * @ClassName: Fibonacci
 * @description: 第九题:斐波那契数列
 * @author: XZQ
 * @create: 2020/4/26 11:20
 * 40:497
 * 41:809
 * 43:2076
 **/
public class Fibonacci {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new Fibonacci().Fib(41));
        System.out.println("耗时：" + (System.currentTimeMillis() - l));
    }

    /*重复计算 效率低下*/
    public long Fib(long n) {
        return n == 0 || n == 1 ? n : Fib(n - 1) + Fib(n - 2);
    }

    /*　要避免重复计算，采用从下往上计算，把计算过了的保存起来*/
    public long Fib2(long n) {
        if (n < 0)
            throw new RuntimeException("参数错误，应该大于等于0");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        long prePre = 0;
        long pre = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}
