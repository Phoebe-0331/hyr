package com.iweb.util;

import java.util.Random;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 11:22
 */
public class StringUtil {
    private static String strPool =
            "ABCDEFGHIGKLMNOPQRSTUVWXYZ" +
                    "abcdefghigklmnopqrstuvwxyz" +
                    "1234567890";
    public static String getRandomStr(){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}
