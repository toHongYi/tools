package com.hongYi.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version : V1.0
 * @date : 2022/6/9 18:40
 * @Author : LLH
 * @Desc :
 */
public class StringTools {
    public static void main(String[] args) {

        //使用正则表达式
        Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");
        //[\u4E00-\u9FA5]是unicode2的中文区间
        Matcher matcher = pattern.matcher("abcd12  34562中文_$,@");
        System.out.println("matcher = " + matcher);
        System.out.println(matcher.replaceAll(""));

        String string="abcd12345ad  6中文_$,@";
        System.out.println(string.replaceAll("[^\\u4e00-\\u9fa5]", ""));

        String operaTime="2022-06-07 17:02:06";
        String prodName="富国全球消费灵活配置混合精选混合(QDII)A";
        String groupName1="大上海是个棒槌";
        String groupName2="202204264324324";
        String groupName3="大上海是个棒槌202204264324324";

        System.out.println("groupName3 = " + calaInteger(operaTime));
        System.out.println("prodName = " + calaInteger(prodName));
        System.out.println("groupName1 = " + calaInteger(groupName1));
        System.out.println("groupName2 = " + calaInteger(groupName2));
        System.out.println("groupName3 = " + calaInteger(groupName3));

        String s = "Excel导出操作日志";
        String b = "20220117";
        String c = "实时";
        StringBuffer sb = new StringBuffer(s);
        sb.insert(0,b);
        System.out.println("sb = " + sb);
        System.out.println("sb = " + sb);
        sb.insert(0,c);
        System.out.println("sb = " + sb);
    }

    /**
     * 计算当前字符串对应列宽;
     * @param str
     * @return
     */
    private static Integer calaInteger(String str){

        int strLength = str.length();
        String chinaTxt = str.replaceAll("[^\\u4e00-\\u9fa5]", "");
        int length = chinaTxt.length();

        Integer rowWidth = length*2 + (strLength-length);
        return rowWidth;
    }
}
