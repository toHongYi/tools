package com.fastjson;

/**
 * @version : V1.0
 * @date : 2021/12/6 11:19
 * @Author : LLH
 * @Description :
 */
public class demo1 {
    public static void main(String[] args) {

        System.out.println(11%2 );
        System.out.println(11/2 );

        System.out.println(307%7 );
        System.out.println(307/7 );

        boolean flag = 10%2 == 1 && 10 / 3 == 0 && 1 / 0 == 0 ;
        System.out.println(flag ? "mldn" : "yootk") ;

        int num302 = 2147483647 ;
        num302 += 2L ;
        System.out.println(num302) ;

        int num301 = 2147483647 ;

        long temp = num301 + 2L ;

        System.out.println(temp) ;
        System.out.println("===============================");

        int num3 = 68 ;
        char c = (char) num3 ;
        char b = (char) 65 ;    //  ASCII表对照第一个A:65 || Z:90 || a:97 || z:122
        char d = (char) 63 ;
        char e = (char) 70 ;
        System.out.println(c) ;
        System.out.println("=================================================");


        int num = 50 ;
        num = num ++ * 2 ;
        System.out.println(num) ;

        System.out.println("==================================");
        int num2 = 2147483647 ;
        num2 += 2L ;
        System.out.println(num2) ;

        System.out.println("==================================");
        int x =10;
        double y = 20.2;
        long z = 10L;
        String str = "" + x + y * z;
        System.out.println("str = " + str);
    }
}
