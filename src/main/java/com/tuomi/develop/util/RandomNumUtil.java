package com.tuomi.develop.util;

import java.util.Random;

public class RandomNumUtil {
    public static String getRandomNum(){
        String randomNum = "";
        Random random = new Random();
        for (int i = 0 ; i < 4 ; i++){
            int num = random.nextInt(10);
            randomNum += num;
        }
        return randomNum;
    }
}
