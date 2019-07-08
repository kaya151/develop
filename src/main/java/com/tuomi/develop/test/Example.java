package com.tuomi.develop.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;



import java.io.PrintWriter;
import java.net.URLConnection;


public class Example {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject postRequestFromUrl(String url, String body) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print(body);
        out.flush();

        InputStream instream = conn.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        } finally {
            instream.close();
        }
    }

    public static JSONObject getRequestFromUrl(String url) throws IOException, JSONException {
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        InputStream instream = conn.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        } finally {
            instream.close();
        }
    }
    public static void main(String[] args) throws IOException, JSONException {

         //请求示例 url 默认请求参数已经做URL编码
        String url = "http://api01.idataapi.cn:8000/article/idataapi?KwPosition=&sourceType=APP&size=50&catLabel1=科技&apikey=RtX27pyCicSZh5j9nf1Oj7MLuAWGw3wwYF52VtIgTPsMEsTrjhuXTmJykAXMEB4i";
        JSONObject json = getRequestFromUrl(url);
        Object data = json.get("data");
        Object retcode = json.get("retcode");
        if (retcode != null) {
            if (retcode.equals("000000")) { //返回状态码"000000"表示正常
                System.out.println(data); //接口返回正常 打印数据内容
            } else { // 其它返回状态码,表示无法继续
                System.out.println(json.getString("message")); //打印状态信息
            }
        }
    }
}
