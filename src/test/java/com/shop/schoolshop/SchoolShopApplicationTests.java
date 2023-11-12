package com.shop.schoolshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class SchoolShopApplicationTests {


    //private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String CHARACTERS = "0123456789";

    @Test
    public static void main(String[] args) {
        int length = 12; // 字符串的长度
        Random random = new Random();

        StringBuilder sb = new StringBuilder(length);
        sb.append("l");
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        String randomString = sb.toString();
        System.out.println(randomString);
}





}
