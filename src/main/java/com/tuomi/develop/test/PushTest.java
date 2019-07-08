package com.tuomi.develop.test;

import com.tuomi.develop.push.PushIos;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class PushTest {
    public static void main(String[] args) throws Exception {
        PushIos pushIos = new PushIos();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("subtitle","sgsgd");
        jsonObject.put("title","ssd");
        pushIos.sendIOSUnicast("5d8090f885f9c30d463d9ec8426f137e3d73b910583f1ca9e163ce8db28f04d3",jsonObject.toString(),"22222","33333");
    }
}
