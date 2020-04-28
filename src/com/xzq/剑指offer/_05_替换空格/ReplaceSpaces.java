package com.xzq.剑指offer._05_替换空格;

/**
 * @ClassName: ReplaceSpaces
 * @description: 面试题5：字符串中的空格替换
 * @author: XZQ
 * @create: 2020/4/25 14:56
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class ReplaceSpaces {
    public static void main(String[] args) {
        ReplaceSpaces rs = new ReplaceSpaces();
        rs.test1();
        rs.test2();
        rs.test3();
        rs.test4();
        System.out.println(rs.replaceSpace2(new StringBuilder("a b d bd c ")));
        System.out.println(rs.replaceSpace3(new StringBuilder("a b d bd c ")));
    }


    public String replaceSpace(StringBuilder str) {
        //如果str为null
        if (str == null) {
            return null;
        }

        int length = str.length();//源来字符串长度
        int indexOfOringinal = length - 1;//原str最后下标的位置
        for (int i = 0; i < str.length(); i++) {
            //如果当前字符为空格
            if (str.charAt(i) == ' ') {
                length += 2;//length+2
            }
        }

        str.setLength(length);
        int indexOfNew = length - 1;//新str最后下标的位置
        while (indexOfOringinal < indexOfNew) {
            if (str.charAt(indexOfOringinal) != ' ') {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOringinal));
            } else {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            indexOfOringinal--;
        }
        return str.toString();
    }

    /*利用StringBuilder的append方法，直接遍历原字符串，如果是空格则追加'%20'到新字符串，
    如果不是空格，直接追加到新字符串末尾。
    开辟了新空间，会增加空间复杂度。*/
    public String replaceSpace2(StringBuilder str) {
        if (str == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {//String.valueOf()将字符转换成字符串
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }

    /*直接使用replaceAll方法*/
    public static String replaceSpace3(StringBuilder str) {
        return str == null ? null : str.toString().replaceAll(" ", "%20");
    }


    // ==================================测试代码==================================

    /**
     * 输入为null
     */
    public void test1() {
        System.out.print("Test1：");
        StringBuilder sBuilder = null;
        String s = replaceSpace(sBuilder);
        System.out.println(s);
    }

    /**
     * 输入为空字符串
     */
    public void test2() {
        System.out.print("Test2：");
        StringBuilder sBuilder = new StringBuilder("");
        String s = replaceSpace(sBuilder);
        System.out.println(s);
    }

    /**
     * 输入字符串无空格
     */
    public void test3() {
        System.out.print("Test3：");
        StringBuilder sBuilder = new StringBuilder("abc");
        String s = replaceSpace(sBuilder);
        System.out.println(s);
    }

    /**
     * 输入字符串为首尾空格，中间连续空格
     */
    public void test4() {
        System.out.print("Test4：");
        StringBuilder sBuilder = new StringBuilder("a b d b ");
        String s = replaceSpace(sBuilder);
        System.out.println(s);
    }
}
