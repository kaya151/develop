package com.tuomi.develop.test;

import com.tuomi.develop.util.RandomNumUtil;
import com.tuomi.develop.util.SmsUtil;

public class SmsTest {
    public static void main(String[] args) {
        String randomNum = RandomNumUtil.getRandomNum();
        System.out.println(randomNum);
        String sms = SmsUtil.getSms(randomNum,"17764827400");
        System.out.println(sms);
    }
}
