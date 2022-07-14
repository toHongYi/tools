package com.hongYi.tools;

/**
 * @version : V1.0
 * @date : 2022/7/5 15:01
 * @Author : LLH
 * @Desc :
 */
public class StringDemo03 {
    public static void main(String[] args) {

        String art = "[a,b]";
        System.out.println("art = " + art);
        String str2 = art.replaceAll("[", "");
        System.out.println("str2 = " + str2);

    }
}
