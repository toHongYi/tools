package com.utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/10/16 17:15
 * @description:
 */
public class NetConnection {

    private static URL url;
    private static HttpURLConnection con;
    private static int state = -1;


    public static void main(String[] args) {

        String trueUrl = "http://mp.weixin.qq.com/s?__biz=MzI3NDE4OTMyOA==&mid=2660554815&idx=2&sn=93751057d765bc10d2c09ccda12f0b5d&scene=0";

        URL connect = isConnect(trueUrl);
        System.out.println("connect = " + connect);

    }


    /**
     * 功能：检测当前URL是否可连接或是否有效,
     * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用
     *
     * @param urlStr 指定URL网络地址
     * @return URL
     */
    public static synchronized URL isConnect(String urlStr) {
        int counts = 0;
        if (urlStr == null || urlStr.length() == 0) {
            return null;
        }
        while (counts < 5) {
            try {
                url = new URL(urlStr);
                con = (HttpURLConnection) url.openConnection();
                state = con.getResponseCode();
                System.out.println(counts + "= " + state);
                if (state == 200) {
                    System.out.println("URL可用！");
                }
                break;
            } catch (Exception ex) {
                counts++;
                System.out.println("URL不可用，连接第 " + counts + " 次");
                urlStr = null;
                continue;
            }
        }
        return url;
    }
}
