package com.xzq.thread;

import lombok.Getter;

/**
 * 枚举 枚举在生产中的使用
 */
public enum CountryEnum {

    One("齐", 1), two("楚", 2),
    three("燕", 3), four("韩", 4), five("赵", 5), six("魏", 6);

    @Getter
    private String retMessage;
    @Getter
    private int retCode;

    CountryEnum(String message, int code) {
        this.retCode = code;
        this.retMessage = message;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] enums = CountryEnum.values();
        for (CountryEnum countryEnum : enums) {
            if (countryEnum.getRetCode() == index) {
                return countryEnum;
            }
        }
        return null;
    }
}
