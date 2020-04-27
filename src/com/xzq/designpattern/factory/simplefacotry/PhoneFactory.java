package com.xzq.designpattern.factory.simplefacotry;

/**
 * @ClassName: PhoneFactory
 * @description:
 * @author: XZQ
 * @create: 2020/3/29 17:06
 **/
public class PhoneFactory {
    public static Phone createPhone(String phoneBrand) {
        if ("Huawei".equals(phoneBrand)) {
            return new HuaweiPhone();
        } else if ("Apple".equals(phoneBrand)) {
            return new ApplePhone();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(PhoneFactory.createPhone("Huawei").brand());
        System.out.println(PhoneFactory.createPhone("Apple").brand());
    }
}
