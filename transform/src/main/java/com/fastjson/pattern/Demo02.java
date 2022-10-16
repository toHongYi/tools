package com.fastjson.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HongYi
 * @version 1.0
 * @date 2022/8/10 15:14
 * @description:
 */
public class Demo02 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Java");

        String test1 = "Java";
        String test2 = "Java1234";
        String test3 = "1234Java";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());

        Matcher matcher2 = pattern.matcher(test2);
        System.out.println(matcher2.matches());
        System.out.println(matcher2.find());
        System.out.println(matcher2.lookingAt());
        System.out.println("===========================================================");

        Matcher matcher3 = pattern.matcher(test3);
        System.out.println(matcher3.matches());
        System.out.println(matcher3.find());
        System.out.println(matcher3.lookingAt());

    }
}
