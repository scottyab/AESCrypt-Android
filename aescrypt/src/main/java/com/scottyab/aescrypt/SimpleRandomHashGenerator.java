package com.scottyab.aescrypt;

import java.security.SecureRandom;

public class SimpleRandomHashGenerator {

    protected static String generate () {
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890.,?!@#$%&*-_+=".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

}
