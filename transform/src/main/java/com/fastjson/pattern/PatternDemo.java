package com.fastjson.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/8/10 13:59
 * @description:
 */
public class PatternDemo {

    public static void main(String[] args) {
        //pattern/expression to be match
        Pattern p1 = Pattern.compile("@Gmail", Pattern.CASE_INSENSITIVE);
        Pattern p2 = Pattern.compile("^" + "/css/*");
        //Regular expression
        Matcher m = p2.matcher("/login");
        System.out.println(m);
        if (m.find()) {
            System.out.println(" Result :  " + m);
        }

        Pattern pattern = Pattern.compile("Java");
        String test = "123Java456Java789Java";

        String[] result = pattern.split(test, 2);
        for (String s : result) {
            System.out.println(s);
        }

        result = pattern.split(test, 10);
        System.out.println(result.length);

        result = pattern.split(test, 0); // 后方数字为返回的字符数组数量;

        result = pattern.split(test, 1);
        System.out.println(result.length);

        result = pattern.split(test, 2);
        System.out.println(result.length);

        result = pattern.split(test, 3);
        System.out.println(result.length);

        result = pattern.split(test, -2);
        System.out.println(result.length);

        result = pattern.split(test, 0);
        System.out.println(result.length);
    }
}
