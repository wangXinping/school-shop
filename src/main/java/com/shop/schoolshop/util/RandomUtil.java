package com.shop.schoolshop.util;

import java.util.Random;

/**
 * 随机值工具类
 */
public class RandomUtil {

    private static final String CHARACTERS = "0123456789";

    public static String createRandom ()
    {
        int length = 12; // 字符串的长度
        Random random = new Random();

        StringBuilder sb = new StringBuilder(length);
        sb.append("l");
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        String randomString = sb.toString();
        //System.out.println(randomString);
        return randomString;
    }

    public static String createOrder ()
    {
        int length = 18; // 字符串的长度
        Random random1 = new Random();

        StringBuilder sb = new StringBuilder(length);
        sb.append("d");
        for (int i = 0; i < length; i++) {
            int index = random1.nextInt(CHARACTERS.length());
            if (i==6){
                sb.append("-");
            }
            sb.append(CHARACTERS.charAt(index));
        }
        String randomString1 = sb.toString();
        //System.out.println(randomString);
        return randomString1;
    }
}
