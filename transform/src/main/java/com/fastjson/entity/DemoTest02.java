package com.fastjson.entity;

/**
 * @version : V1.0
 * @date : 2022/5/5 17:00
 * @Author : LLH
 * @Desc :
 */
public class DemoTest02 {
    public static void main(String[] args) {
        String str1 = " \"name\" " ;
        // 字符串两边含有双引号 5
        String str2 = " name \"is\" zcr " ;
        // 字符串中间含有双引号 6
        String str3 = " \\name " ;

        String str4 = "{\n" +
                "      \"prodGroupID\": 3223,\n" +
                "      \"mainObject\": 1,\n" +
                "      \"calcStatus\": 0\n" +
                "    }";

        // 使用转义字符还可以使字符串包含其他字符
        System.out.println( " 字符串一： " + str1);
        System.out.println( " 字符串二： " + str2);
        System.out.println( " 字符串三： " + str3);
        System.out.println( " 字符串四： " + str4);

    }
}
